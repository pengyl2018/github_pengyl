package tenth_Febonacci;

/**
 * 求斐波那契数列
 * f(0) = 0; f(1) = 1; f(n) = f(n-1) + f(n-2)
 *
 * 类似题目：青蛙一次只能跳一步或者两步；  用1*2的砖块去填补8*2的区域；
 */
public class Febonacci {
    /*
    采用递归的方式
     */
    public static int getFebo(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return getFebo(n - 1) + getFebo(n - 2);
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
        System.out.println(getFebo(40));
        long t1 = System.currentTimeMillis();
        System.out.println("递归方式的时间：" + (t1 - t0)); //耗时1秒左右
        System.out.println(getFebo2(40));
        System.out.println("循环方式的时间：" + (System.currentTimeMillis() - t1));  //耗时0
    }
}
