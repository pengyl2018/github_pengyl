package dynamicprogramming;

/**
 * 乘机最大子序列:
 * 例如：输入[2,3,-2,4]，输出6；输入[-2,0,-1]，输出0
 */
public class MaxProductSubsequence {
    public static void main(String[] args) {
        MaxProductSubsequence maxProductSubsequence = new MaxProductSubsequence();
        int[] input1 = new int[]{2, 3, -2, 4};
        System.out.println(maxProductSubsequence.maxProduct(input1));
        int[] input2 = new int[]{-2, 0, -1};
        System.out.println(maxProductSubsequence.maxProduct(input2));
    }

    /**
     * 1.定义状态：dpMax[i]表示到第i个数为止的最大乘积；dpMin[i]表示到第i个数为止的最小乘积
     * 2.dp方程：
     * 假如没有负数，全是正数：
     * dpMax[i] = Math.max(dpMax[i-1] * nums[i], nums[i])
     * dpMin[i] = Math.min(dpMin[i-1] * nums[i], nums[i])
     * 有正数也有负数：
     * dpMax[i] = Math.max(nums[i], Math.max(dpMax[i-1] * nums[i], dpMin[i-1] * nums[i]))
     * dpMin[i] = Math.min(nums[i], Math.min(dpMax[i-1] * nums[i], dpMin[i-1] * nums[i]))
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] dpMax = new int[length];
        int[] dpMin = new int[length];
        dpMax[0] = dpMin[0] = nums[0];
        for (int i = 1; i < length; i++) {
            dpMax[i] = Math.max(nums[i], Math.max(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]));
            dpMin[i] = Math.min(nums[i], Math.min(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]));
        }
        int maxProduct = dpMax[0];
        for (int i = 1; i < length; i++) {
            maxProduct = Math.max(maxProduct, dpMax[i]);
        }
        return maxProduct;
    }
}
