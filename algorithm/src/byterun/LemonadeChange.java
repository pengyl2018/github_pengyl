package byterun;

import common.CommonUtil;

/**
 * At a lemonade stand, each lemonade costs ￥5.
 * <p>
 * Customers are standing in a queue to buy from you, and order one at a time (in the order specified by bills).
 * <p>
 * Each customer will only buy one lemonade and pay with either a ￥5, ￥10, or ￥20 bill. You must provide the correct change to each customer, so that the net transaction is that the customer pays ￥5.
 * <p>
 * Note that you don’t have any change in hand at first.
 * 这道题说是有很多柠檬，每个卖5刀，顾客可能会提供5刀，10刀，20刀的钞票，我们刚开始的时候并没有零钱，
 * 只有收到顾客的5刀，或者 10 刀可以用来给顾客找钱，当然如果第一个顾客就给 10 刀或者 20 刀，那么是无法找零的，这里就问最终是否能够都成功找零。
 * <p>
 * Example 1:
 * Input: [5,5,5,10,20]
 * Output: true
 * <p>
 * Example 2:
 * Input: [5,5,10]
 * Output: true
 * <p>
 * Example 3:
 * Input: [10,10]
 * Output: false
 * <p>
 * Example 4:
 * Input: [5,5,10,10,20]
 * Output: false
 */
public class LemonadeChange {
    public static void main(String[] args) {
        int[] input = new int[]{5, 5, 5, 10, 20};
        CommonUtil.printBool(judge(input));
        input = new int[]{5, 5, 10};
        CommonUtil.printBool(judge(input));
        input = new int[]{10, 10};
        CommonUtil.printBool(judge(input));
        input = new int[]{5, 5, 10, 10, 20};
        CommonUtil.printBool(judge(input));
    }

    /**
     * 其实上我们只关心当前还剩余的5刀和 10 刀钞票的个数，用两个变量 five 和 ten 来记录。然后遍历所有的钞票，假如遇到5刀钞票，则 five 自增1，
     * 若遇到 10 刀钞票，则需要找零5刀，则 five 自减1，ten 自增1。否则遇到的就是 20 刀的了，若还有 10 刀的钞票话，就先用 10 刀找零，则 ten 自减1，
     * 再用一张5刀找零，five 自减1。若没有 10 刀了，则用三张5刀找零，five 自减3。找零了后检测若此时5刀钞票个数为负数了，则直接返回 false
     *
     * @param input 输入
     * @return 输出是否能满足
     */
    private static boolean judge(int[] input) {
        // 用来记录剩余的5元张数和10元张数
        int five = 0, ten = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == 5) {
                five++;
            } else if (input[i] == 10) {
                ten++;
                five--;
            } else if (input[i] == 20 && ten > 0) {
                ten--;
                five--;
            } else {
                five -= 3;
            }
            if (five < 0) {
                return false;
            }
        }
        return true;
    }
}
