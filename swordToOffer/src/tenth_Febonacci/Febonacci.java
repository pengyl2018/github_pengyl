package tenth_Febonacci;

import java.util.HashMap;
import java.util.Map;

/**
 * 求斐波那契数列
 * f(0) = 0; f(1) = 1; f(n) = f(n-1) + f(n-2)
 * <p>
 * 类似题目：青蛙一次只能跳一步或者两步；  用1*2的砖块去填补8*2的区域；
 */
public class Febonacci {
    /*
    采用递归的方式
     */
    public static int getFebo(int n, Map<Integer, Integer> map) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int n_1 = getFebo(n - 1, map);
        int n_2 = getFebo(n - 2, map);
        map.put(n - 1, n_1);
        map.put(n - 2, n_2);
        return n_1 + n_2;
    }

    /*
    采用循环的方式
     */
    public static int getFebo2(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int value1 = 0;
        int value2 = 1;
        int tempSum = 0;
        for (int i = 2; i <= n; i++) {
            tempSum = value1 + value2;
            value1 = value2;
            value2 = tempSum;
        }
        return tempSum;
    }

    public static void main(String[] args) {
        long t0 = System.currentTimeMillis();
        Map<Integer, Integer> map = new HashMap<>();
        System.out.println(getFebo(45, map));
        long t1 = System.currentTimeMillis();
        System.out.println("递归方式的时间：" + (t1 - t0)); //耗时0秒左右
        System.out.println(getFebo2(45));
        System.out.println("循环方式的时间：" + (System.currentTimeMillis() - t1));  //耗时0
    }
}
