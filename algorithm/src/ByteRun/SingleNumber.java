package ByteRun;

import common.CommonUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * <p>
 * Note:
 * <p>
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p>
 * Example 1:
 * <p>
 * Input: [2,2,1]
 * Output: 1
 * Example 2:
 * <p>
 * Input: [4,1,2,1,2]
 * Output: 4
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] array = new int[]{2, 2, 1};
        CommonUtil.printNumber(getSingleNum(array));
        CommonUtil.printNumber(getSingleNum2(array));
        array = new int[]{4, 1, 2, 1, 2};
        CommonUtil.printNumber(getSingleNum(array));
        CommonUtil.printNumber(getSingleNum2(array));
    }

    // 解法一：使用hashSet，遍历所有数字，若在hashSet中存在，则将数字从中去掉，否则放入，最后剩下了那个出现一次的数
    private static int getSingleNum(int[] arrays) {
        Set<Integer> set = new HashSet<>();
        for (int arr : arrays) {
            if (set.contains(arr)) {
                set.remove(arr);
            } else {
                set.add(arr);
            }
        }
        return set.iterator().next();
    }

    // 解法二：所有数字都异或一次，最后剩余那个出现一次的数
    private static int getSingleNum2(int[] arrasys) {
        if (arrasys == null) {
            return 0;
        }
        int initNum = arrasys[0];
        for (int i = 1; i < arrasys.length; i++) {
            initNum ^= arrasys[i];
        }
        return initNum;
    }
}
