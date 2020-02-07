1.Lambda表达式
语法格式：
用逗号分隔的参数列表、-> 符号、语句块 组成

Arrays.asList( "a", "b", "d" ).forEach( e -> System.out.println( e ) );
等价于
List<String> list = Arrays.asList( "a", "b", "d" );
for(String e:list){
    System.out.println(e);
}

如果语句块比较复杂，使用 {} 包起来
Arrays.asList( "a", "b", "d" ).forEach( e -> {
    String m = "9420 "+e;
    System.out.print( m );
});


Lambda 的返回值和参数类型由编译器推理得出，不需要显示定义，如果只有一行代码可以不写 return 语句
Arrays.asList( "a", "b", "d" ).sort( ( e1, e2 ) -> e1.compareTo( e2 ) );
等价于
List<String> list = Arrays.asList("a", "b", "c");
Collections.sort(list, new Comparator<String>() {
    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }
});



2.函数式接口
（1）接口中只能有一个接口方法
（2）可以有静态方法和默认方法
（3）使用 @FunctionalInterface 标记
（4）默认方法可以被覆写
@FunctionalInterface
public interface FunctionalDefaultMethods {
    void method();

    default void defaultMethod() {
    }

    static void staticMethod(){
    }
}
private interface Defaulable {
    // Interfaces now allow default methods, the implementer may or
    // may not implement (override) them.
    default String notRequired() {
        return "Default implementation";
    }
}

private static class DefaultableImpl implements Defaulable {
}

private static class OverridableImpl implements Defaulable {
    @Override
    public String notRequired() {
        return "Overridden implementation";
    }
}

// 也可以由接口覆盖
public interface OverridableInterface extends Defaulable{
    @Override
    public String notRequired() {
        return "interface Overridden implementation";
    }
}

已经存在的 Java8 定义的函数式接口
我们基本不需要定义自己的函数式接口，Java8 已经给我们提供了大量的默认函数式接口，基本够用，在 rt.jar 包的 java.util.function 目录下可以看到所有默认的函数式接口，大致分为几类

Function<T,R> T 作为输入，返回的 R 作为输出
Predicate<T> T 作为输入 ，返回 boolean 值的输出
Consumer<T> T 作为输入 ，没有输出
Supplier<R> 没有输入 , R 作为输出
BinaryOperator<T> 两个 T 作为输入 ，T 同样是输出
UnaryOperator<T> 是 Function 的变种 ，输入输出者是 T



3.流stream
forEach 遍历Collection 数据
vehicles.forEach(vehicle -> System.out.println(vehicle));

forEach 遍历 Map 数据
Map<String,Integer> map = new HashMap<>();
map.forEach((k,v) -> System.out.println("key:"+k+",value:"+v));

filter 数据过滤
// 去掉评分为 3 分以下的车
List<Vehicle> collect = vehicles.stream().filter(vehicle -> vehicle.getScore() >= 3).collect(Collectors.toList());

map 对象映射
// 取出所有的车架号列表
List<String> vins = vehicles.stream().map(vehicle -> vehicle.getVin()).collect(Collectors.toList());

groupBy 按照某个属性进行分组
// 按照公司 Id 进行分组
Map<Integer, List<Vehicle>> companyVehicles = vehicles.stream().collect(Collectors.groupingBy(Vehicle::getCompanyId));

// 按照公司分组求司机打分和
Map<Integer, Double> collect = vehicles.stream().collect(Collectors.groupingBy(Vehicle::getCompanyId, Collectors.summingDouble(Vehicle::getScore)));

sort 按照某个属性排序 ，及多列排序
// 单列排序
vehicles.sort((v1,v2) -> v2.getScore().compareTo(v1.getScore()));

// 或使用 Comparator 类来构建比较器，流处理不会改变原列表，需要接收返回值才能得到预期结果
 List<Vehicle> collect = vehicles.stream().sorted(Comparator.comparing(Vehicle::getScore).reversed()).collect(Collectors.toList());

// 多列排序，score 降序，companyId 升序排列
List<Vehicle> collect = vehicles.stream().sorted(Comparator.comparing(Vehicle::getScore).reversed().thenComparing(Comparator.comparing(Vehicle::getCompanyId)))
                .collect(Collectors.toList());

flatMap 扁平化数据处理
// 查出所有车绑定的所有设备
List<String> collect = vehicles.stream().map(vehicle -> {
    String deviceNos = vehicle.getDeviceNos();
    return StringUtils.split(deviceNos,',');
}).flatMap(Arrays::stream).collect(Collectors.toList());
flatMap 很适合 List<List> 或 List<object []> 这种结构，可以当成一个列表来处理；像上面的设备列表，在数据库中存储的结构就是以逗号分隔的数据，而车辆列表又是一个列表数据。

mapReduce 数据处理
// 对所有司机的总分求和
Double reduce = vehicles.stream().parallel().map(Vehicle::getScore).reduce(0d, Double::sum);

综合处理示例
// 总的分值
Double totalScore = vehicles.stream().parallel().map(Vehicle::getScore).reduce(0d, Double::sum);

// 查看每一个司机占的分值比重
List<String> collect = vehicles.stream()
    .mapToDouble(vehicle -> vehicle.getScore() / totalScore)
    .mapToLong(weight -> (long) (weight * 100))
    .mapToObj(percentage -> percentage + "%")
    .collect(Collectors.toList());

Optional
Optional 用来解决 Java 中经常出现的 NullPointerException ，从而避免源码被各种空检查污染，使源码更加简洁和更加容易阅读
// 假设有一个对象 obj ,你不知道它是不是为空的，但是你想用它的方法，可以这么玩
Optional<T> canUseObj = Optional.ofNullable(obj);
canUseObj.ifPresent(System.out::println);       //如果 obj 不为空，则可以使用 obj 的方法，这里做个简单输出