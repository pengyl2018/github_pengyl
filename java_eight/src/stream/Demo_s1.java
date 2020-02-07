package stream;

import com.sun.deploy.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class Demo_s1 {
    static List<Vehicle> vehicles = new ArrayList<>();

    public static void main(String[] args) {
        new Demo_s1().init();
        System.out.println("forEach 遍历Collection 数据");
        vehicles.forEach(vehicle -> System.out.println(vehicle));

        System.out.println("--------------");
        System.out.println("forEach 遍历 Map 数据");
        Map<String, Integer> map = new HashMap<>();
        map.forEach((k, v) -> System.out.println("key:" + k + ",value:" + v));

        System.out.println("--------------");
        System.out.println("filter 数据过滤,去掉评分为 3 分以下的车");
        List<Vehicle> collect = vehicles.stream().filter(vehicle -> vehicle.getScore() >= 3).collect(Collectors.toList());
        System.out.println(collect.toString());

        System.out.println("--------------");
        System.out.println("map 对象映射,取出所有的车架号列表");
        List<String> vins = vehicles.stream().map(vehicle -> vehicle.getVin()).collect(Collectors.toList());
        System.out.println(vins.toString());

        System.out.println("--------------");
        System.out.println("groupBy 按照某个属性进行分组,要求按照公司 Id 进行分组");
        Map<Integer, List<Vehicle>> companyVehicles = vehicles.stream().collect(Collectors.groupingBy(Vehicle::getCompanyId));
        System.out.println(companyVehicles.toString());

        System.out.println("--------------");
        System.out.println("按照公司分组求司机打分和");
        Map<Integer, Double> map1 = vehicles.stream().collect(Collectors.groupingBy(Vehicle::getCompanyId, Collectors.summingDouble(Vehicle::getScore)));
        System.out.println(map1.toString());

        System.out.println("--------------");
        System.out.println("sort 按照某个属性排序 ，及多列排序，此处是单列排序");
        vehicles.sort((v1, v2) -> v2.getScore().compareTo(v1.getScore()));
        System.out.println(vehicles.toString());

        System.out.println("--------------");
        System.out.println("使用 Comparator 类来构建比较器，流处理不会改变原列表，需要接收返回值才能得到预期结果");
        List<Vehicle> list1 = vehicles.stream().sorted(Comparator.comparing(Vehicle::getScore).reversed()).collect(Collectors.toList());
        System.out.println(list1.toString());

        System.out.println("--------------");
        System.out.println("多列排序，score 降序，companyId 升序排列");
        List<Vehicle> list2 = vehicles.stream().sorted(Comparator.comparing(Vehicle::getScore).reversed().thenComparing(Comparator.comparing(Vehicle::getCompanyId)))
                .collect(Collectors.toList());
        System.out.println(list2.toString());

        System.out.println("--------------");
        System.out.println("flatMap 扁平化数据处理，查出所有车绑定的所有设备");
        List<String> list3 = vehicles.stream().map(vehicle -> {
            String deviceNos = vehicle.getDeviceNos();
            return StringUtils.splitString(deviceNos, ",");
        }).flatMap(Arrays::stream).collect(Collectors.toList());
        System.out.println(list3.toString());
        //flatMap 很适合 List<List> 或 List<object[]> 这种结构，可以当成一个列表来处理；像上面的设备列表，在数据库中存储的结构就是以逗号分隔的数据，而车辆列表又是一个列表数据。

        System.out.println("--------------");
        System.out.println("mapReduce 数据处理，对所有司机的总分求和");
        Double totalScore = vehicles.stream().parallel().map(Vehicle::getScore).reduce(0d, Double::sum);
        System.out.println(totalScore);

        System.out.println("--------------");
        System.out.println("查看每一个司机占的分值比重");
        List<String> list4 = vehicles.stream()
                .mapToDouble(vehicle -> vehicle.getScore() / totalScore)
                .mapToLong(weight -> (long) (weight * 100))
                .mapToObj(percentage -> percentage + "%")
                .collect(Collectors.toList());
        System.out.println(list4.toString());

        //Optional
        //Optional 用来解决 Java 中经常出现的 NullPointerException ，从而避免源码被各种空检查污染，使源码更加简洁和更加容易阅读
        // 假设有一个对象 obj ,你不知道它是不是为空的，但是你想用它的方法，可以这么玩
        //Optional<T> canUseObj = Optional.ofNullable(obj);
        //canUseObj.ifPresent(System.out::println);       //如果 obj 不为空，则可以使用 obj 的方法，这里做个简单输出
    }

    public void init() {
        List<String> imeis = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            List<String> singleVehicleDevices = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                String imei = "abcde" + j;
                singleVehicleDevices.add(imei);
            }
            imeis.add(StringUtils.join(singleVehicleDevices, ","));
        }
        vehicles.add(new Vehicle("KPTSOA1K67P081452", "17620411498", "9420", 1, 4.5, imeis.get(0)));
        vehicles.add(new Vehicle("KPTCOB1K18P057071", "15073030945", "张玲", 2, 1.4, imeis.get(1)));
        vehicles.add(new Vehicle("KPTS0A1K87P080237", "19645871598", "sanri1993", 1, 3.0, imeis.get(2)));
        vehicles.add(new Vehicle("KNAJC526975740490", "15879146974", "李种", 1, 3.9, imeis.get(3)));
        vehicles.add(new Vehicle("KNAJC521395884849", "13520184976", "袁绍", 2, 4.9, imeis.get(4)));
    }
}

