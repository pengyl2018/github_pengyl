package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * 最长上升子序列
 * 例如：10,9,2,5,3,7,101,18,20的最长上升子序列的个数是5，是2，3，7，18，20这5个数
 */
public class LongestIncreasingSequence {
    public static void main(String[] args) {
        LongestIncreasingSequence sequence = new LongestIncreasingSequence();
        int[] items = new int[]{10, 9, 2, 5, 3, 7, 101, 18, 20};
        System.out.println("方法1：" + sequence.getLongestNumber(items));
        System.out.println("方法2：" + sequence.getLongestNumber2(items));
    }

    /**
     * 方法1：动态规划，时间复杂度：o(n*n)
     * dp状态定义：dp[i]表示到第i个数为止最长的子序列个数
     * dp方程:dp[i] = max{dp[j]} + 1，其中j:0->i-1且a[j]<a[i]
     *
     * @param items
     * @return
     */
    private int getLongestNumber(int[] items) {
        // 定义初始的最长子序列个数
        int res = 1;
        int[] dp = new int[items.length];
        for (int i = 0; i < items.length; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < items.length; i++) {
            for (int j = 0; j < i; j++) {
                if (items[j] < items[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * 方法2：时间复杂度o(nlogn)
     * 算法：准备一个有序的列表，遍历每一个数，当前这个数比列表中的最后一个数还大，直接将这个数添加到列表末尾；
     * 否则找到列表中所有比当前数大的数中最小的那个数，将当前数替换之；最后最长子序列的长度就是列表的大小。
     *
     * @param items
     * @return
     */
    private int getLongestNumber2(int[] items) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < items.length; i++) {
            if (list.isEmpty() || list.get(list.size() - 1) < items[i]) {
                list.add(items[i]);
                continue;
            }
            int index = binarySearch(list, items[i]);
            list.set(index, items[i]);
        }
        return list.size();
    }

    /**
     * 二分查找符合要求的位置下标
     *
     * @param list
     * @param target
     * @return
     */
    private int binarySearch(List<Integer> list, int target) {
        int low = 0;
        int high = list.size() - 1;
        int mid = (low + high) / 2;
        while (low < high) {
            mid = (low + high) / 2;
            if (list.get(mid) == target) {
                return mid;
            } else if (list.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
