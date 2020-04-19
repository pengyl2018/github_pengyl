package ByteRun;

/**
 * Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
 * <p>
 * Note:
 * <p>
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p>
 * Example 1:
 * <p>
 * Input: [2,2,3,2]
 * Output: 3
 * Example 2:
 * <p>
 * Input: [0,1,0,1,0,1,99]
 * Output: 99
 */
public class SingleNumberII {
    public static void main(String[] args) {
        int[] array = new int[]{2, 2, 3, 2};
        System.out.println(getSingleNumber(array));
        array = new int[]{0, 1, 0, 1, 0, 1, 99};
        System.out.println(getSingleNumber(array));
    }

    /*
    将每个数当做一个32位的数组来看.
    对于每一位，所有数字的那一位都加起来并对3取模，结果那一位为1（出现一次）或者为0（没出现），每一位都是如此
     */
    private static int getSingleNumber(int[] array) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int j = 0; j < array.length; j++) {
                sum += (array[j] >> i) & 1;
            }
            result |= (sum % 3) << i;
        }
        return result;
    }
}
