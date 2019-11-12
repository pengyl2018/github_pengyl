package xxxxxxxxxxxxxxxxxxxxxxxxxx;

/**
 * 数值的整数次方
 */
public class Power {
    public static double power(int base, int index) {
        if (base == 0 && index == 0) {
            throw new RuntimeException("base and index cannot be 0 at the same time");
        }

        if (index < 0) {
            index = -index;
            double result2 = (double) recursiveCompute(base, index);
            result2 = 1 / result2;
            return result2;
        }
        double result = (double) recursiveCompute(base, index);
        return result;
    }

    /*
    只是针对正整数
     */
    public static int recursiveCompute(int base, int index) {
        if (index == 0) {
            return 1;
        }

        if (index == 1) {
            return base;
        }

        int result = recursiveCompute(base, index / 2);
        result *= result;
        if (index % 2 == 1) { //指数是奇数，结果需要再乘一次base
            result *= base;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(power(2, -3));
        System.out.println(recursiveCompute(2, 7));
    }
}
