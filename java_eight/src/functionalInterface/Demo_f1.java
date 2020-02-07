package functionalInterface;

import java.util.function.*;

/**
 * 已经存在的 Java8 定义的函数式接口
 * Function<T,R> T 作为输入，返回的 R 作为输出
 * Predicate<T> T 作为输入 ，返回 boolean 值的输出
 * Consumer<T> T 作为输入 ，没有输出
 * Supplier<R> 没有输入 , R 作为输出
 * BinaryOperator<T> 两个 T 作为输入 ，T 同样是输出
 * UnaryOperator<T> 是 Function 的变种 ，输入输出者是 T
 */
public class Demo_f1 {
    public static void main(String[] args) {
        // hello world 示例
        Function<String, String> function = (x) -> {
            return x + "Function";
        };
        System.out.println(function.apply("hello world"));  // hello world Function

        UnaryOperator<String> unaryOperator = x -> x + 2;
        System.out.println(unaryOperator.apply("9420-"));   // 9420-2

        // 判断输入值是否为偶数示例
        Predicate<Integer> predicate = (x) -> {
            return x % 2 == 0;
        };
        System.out.println(predicate.test(1));              // false

        // 这个没有返回值
        Consumer<String> consumer = (x) -> {
            System.out.println(x);
        };
        consumer.accept("hello world ");                    // hello world

        // 这个没有输入
        Supplier<String> supplier = () -> {
            return "Supplier";
        };
        System.out.println(supplier.get());                 // Supplier

        // 找出大数
        BinaryOperator<Integer> bina = (x, y) -> {
            return x > y ? x : y;
        };
        System.out.println(bina.apply(1, 2));          // 2
    }
}
