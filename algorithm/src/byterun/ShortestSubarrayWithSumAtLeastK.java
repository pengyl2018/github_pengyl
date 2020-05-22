package byterun;

import common.CommonUtil;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Return the length of the shortest, non-empty, contiguous subarray of A with sum at least K.
 * <p>
 * If there is no non-empty subarray with sum at least K, return -1.
 * <p>
 * Example 1:
 * <p>
 * Input: A = [1], K = 1
 * Output: 1
 * <p>
 * Example 2:
 * Input: A = [1,2], K = 4
 * Output: -1
 * <p>
 * Example 3:
 * Input: A = [2,-1,2], K = 3
 * Output: 3
 */
public class ShortestSubarrayWithSumAtLeastK {
    public static void main(String[] args) {
        int[] input = new int[]{1};
        int K = 1;
        CommonUtil.printNumber(getShortestLength(input, K));
        CommonUtil.printNumber(getShortestLength2(input, K));
        input = new int[]{1, 2};
        K = 4;
        CommonUtil.printNumber(getShortestLength(input, K));
        CommonUtil.printNumber(getShortestLength2(input, K));
        input = new int[]{2, -1, 2};
        K = 3;
        CommonUtil.printNumber(getShortestLength(input, K));
        CommonUtil.printNumber(getShortestLength2(input, K));
    }

    /**
     * 方法一：
     * 记 ，前 x 数（包括第 x 个数）的和为 frontSum[x]， 则第 i 个数到第 j 个数的和为 frontSum[j]-frontSum[i-1]。
     * 遍历 i, j 的情况，求出和大于等于 K， 且长度最小的数组即可。复杂度 O(n^2)。
     *
     * @param input
     * @return
     */
    private static int getShortestLength(int[] input, int K) {
        int[] frontSum = new int[input.length + 1];
        for (int i = 1; i <= input.length; i++) {
            frontSum[i] = frontSum[i - 1] + input[i - 1];
        }
        int ant = -1;
        for (int i = 0; i < input.length; i++) {
            for (int j = i; j < input.length; j++) {
                if (frontSum[j + 1] - frontSum[i] >= K && (ant == -1 || j - i + 1 < ant)) {
                    ant = j - i + 1;
                    break;
                }
            }
        }
        return ant;
    }

    /**
     * 方法二
     * 在建立好累加和数组之和，遍历其每个累加和，然后用一个 while 循环，从双向队列的开头开始遍历，
     * 假如区间和之差大于等于K，就移除队首元素并更新结果 res。之后这个 while 循环非常重要，能有这么高的击败率，
     * 全要靠这个循环，这个是从双向队列的末尾开始往前遍历，假如当前区间和 sums[i] 小于等于队列末尾的区间和，
     * 则移除队列末尾元素。这是为啥呢？因为若数组都是正数，那么长度越长，区间和一定越大，
     * 则 sums[i] 一定大于所有双向队列中的区间和，但由于可能存在负数，从而使得长度变长，区间总和反而减少了，
     * 之前的区间和之差都没有大于等于K，现在的更不可能大于等于K，这个结束位置可以直接淘汰，不用进行计算。
     * 循环结束后将当前位置加入双向数组即可
     *
     * @param input
     * @param K
     * @return
     */
    private static int getShortestLength2(int[] input, int K) {
        int[] frontSum = new int[input.length + 1];
        int res = Integer.MAX_VALUE;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= input.length; i++) {
            frontSum[i] = frontSum[i - 1] + input[i - 1];
        }
        for (int i = 0; i <= input.length; i++) {
            while (!deque.isEmpty() && frontSum[i] - frontSum[deque.peekFirst()] >= K) {
                res = Math.min(res, i - deque.peekFirst());
                deque.pollFirst();
            }
            while (!deque.isEmpty() && frontSum[i] < frontSum[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
