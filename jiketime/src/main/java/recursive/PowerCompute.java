package recursive;

/**
 * 求power（x,y），即x^y
 */
public class PowerCompute {
    public static void main(String[] args) {
        PowerCompute powerCompute = new PowerCompute();
        // 测试方法1
        System.out.println("2^5:" + powerCompute.getPower1(2, 20));
        System.out.println("2^(-5):" + powerCompute.getPower1(2, -20));
        // 测试方法2
        System.out.println("2^5:" + powerCompute.getPower2(2, 20));
        System.out.println("2^(-5):" + powerCompute.getPower2(2, -20));
    }

    /**
     * 采用循环连续相乘，时间复杂度为o(n)，不推荐
     *
     * @param x
     * @param y
     * @return
     */
    private double getPower1(int x, int y) {
        if (y < 0) {
            return ((double) 1) / power(x, -y);
        } else if (y == 0) {
            return 1;
        } else {
            return power(x, y);
        }
    }

    /**
     * 采用增大底数，减少指数的方式，时间复杂度为o(logn)，推荐
     * @param x
     * @param y
     * @return
     */
    private double getPower2(int x, int y) {
        if (y == 1) {
            return x;
        }
        if (y < 0) {
            return ((double) 1) / getPower2(x, -y);
        }
        if (y % 2 == 0) {
            return getPower2(x * x, y / 2);
        } else {
            return x * getPower2(x, y - 1);
        }
    }

    private int power(int x, int y) {
        int multipleResult = 1;
        for (int i = 0; i < y; i++) {
            multipleResult *= x;
        }
        return multipleResult;
    }
}
