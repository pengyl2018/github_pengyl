package byterun;

import common.CommonUtil;

/**
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list.
 * <p>
 * <p>
 * <p>
 * 将一个数字的每个位上的数字分别存到一个一维向量中，最高位在最开头，我们需要给这个数字加一，即在末尾数字加一，
 * 如果末尾数字是9，那么则会有进位问题，而如果前面位上的数字仍为9，则需要继续向前进位。
 * 具体算法如下：首先判断最后一位是否为9，若不是，直接加一返回，若是，则该位赋0，再继续查前一位，
 * 同样的方法，知道查完第一位。如果第一位原本为9，加一后会产生新的一位，那么最后要做的是，查运算完的第一位是否为0，
 * 如果是，则在最前头加一个1。
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3, 4, 5, 6, 7};
        CommonUtil.printArray(plusOne(input));
        input = new int[]{1, 1, 1, 9};
        CommonUtil.printArray(plusOne(input));
        input = new int[]{9, 9, 9};
        CommonUtil.printArray(plusOne(input));
    }

    private static int[] plusOne(int[] input) {
        for (int i = input.length - 1; i >= 0; i--) {
            if (input[i] < 9) {
                input[i]++;
                return input;
            }
            input[i] = 0;
        }
        int[] ext = new int[input.length + 1];
        ext[0] = 1;
        System.arraycopy(input, 0, ext, 1, input.length);
        return ext;
    }
}
