package recursive;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        // 方法1
        long t1 = System.currentTimeMillis();
        System.out.println("fibo(45):" + fibonacci.getFibo1(45));
        long t2 = System.currentTimeMillis();
        System.out.println("方法1时间：" + (t2 - t1));
        // 方法2
        Map<Integer, Integer> existMap = new HashMap<>(30);
        System.out.println("fibo(45):" + fibonacci.getFibo2(45, existMap));
        long t3 = System.currentTimeMillis();
        System.out.println("方法2时间：" + (t3 - t2));
        // 方法3
        System.out.println("fibo(45):" + fibonacci.getFibo3(45));
        System.out.println("方法3时间：" + (System.currentTimeMillis() - t3));
    }

    /**
     * 有大量重复计算，不推荐
     *
     * @param n
     * @return
     */
    private int getFibo1(int n) {
        return n <= 1 ? n : getFibo1(n - 1) + getFibo1(n - 2);
    }

    /**
     * 已经算得的结果缓存在内存中，防止重复计算
     *
     * @param n
     * @param existMap
     * @return
     */
    private int getFibo2(int n, Map<Integer, Integer> existMap) {
        if (n <= 1) {
            return n;
        }
        if (!existMap.containsKey(n)) {
            int fibo_n1 = getFibo2(n - 1, existMap);
            int fibo_n2 = getFibo2(n - 2, existMap);
            existMap.put(n, fibo_n1 + fibo_n2);
        }
        return existMap.get(n);
    }

    /**
     * 非递归，使用正向递推的方式
     *
     * @param n
     * @return
     */
    private int getFibo3(int n) {
        if (n <= 1) {
            return n;
        }
        int[] fibos = new int[n + 1];
        fibos[0] = 0;
        fibos[1] = 1;
        for (int i = 2; i <= n; i++) {
            fibos[i] = fibos[i - 1] + fibos[i - 2];
        }
        return fibos[n];
    }
}
