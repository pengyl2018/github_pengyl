package xxxxxxxxxxxxxxxxxxxxxxxxxx;

/**
 * 输入一个整数，输出该二进制中1的个数。例如，9的二进制表示是1001，因此，如果输入9，输出2。
 */
public class NumberOfOne {
    /*
    解法1
     */
    public static int numberOfOne(int number) {
        int count = 0;
        // java中整形共有32位，将每一位都和1做与运算
        for (int i = 0; i < 32; i++) {
            count += (number & 1);
            number >>>= 1;
        }
        return count;
    }

    /*
    解法2
     */
    public static int numberOfOne2(int number) {
        int count = 0;
        while (number != 0) {
            count++;
            // 每次运算会将最右边的1转化为0，因此循环的次数为1的数量
            number = number & (number - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numberOfOne(9));
        System.out.println(numberOfOne2(9));
    }
}
