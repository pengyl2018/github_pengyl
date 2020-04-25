package ByteRun;

import common.CommonUtil;

/**
 * Given two non-negative numbers num1 and num2 represented as string, return the sum of num1 and num2.
 *
 * Note:
 *
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * 两个字符串相加
 */
public class AddStrings {
    public static void main(String[] args) {
        String num1 = "1234";
        String num2 = "561234";
        CommonUtil.printStirng(addTwoString(num1, num2));
        num1 = "12345";
        num2 = "612345";
        CommonUtil.printStirng(addTwoString(num1, num2));
        num1 = "5555";
        num2 = "5222";
        CommonUtil.printStirng(addTwoString(num1, num2));
    }

    private static String addTwoString(String num1, String num2) {
        int length = num1.length() > num2.length() ? num1.length() : num2.length();
        char[] numArr1 = num1.toCharArray();
        char[] numArr2 = num2.toCharArray();
        char[] result = new char[length + 1];
        int i = numArr1.length - 1, j = numArr2.length - 1, k = result.length - 1, carry = 0;
        while (i>=0 || j>=0 || k > 0) {
            // 循环内部再次判断是否大于0，原因：循环过程中有可能其中一个数字位数较短，另一个较长
            int a = i >= 0 ? numArr1[i--] - '0' : 0;
            int b = j >= 0 ? numArr2[j--] - '0' : 0;
            int sum = a + b + carry;
            result[k--] = (char) (sum%10 + '0');
            carry = sum /10;
        }
        if (carry >0 ) {
            result[k] = '1';
        }
        return String.valueOf(result);
    }
}
