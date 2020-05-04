package byterun;

import common.CommonUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
 *
 * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.
 *
 * Example 1:
 *
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * Output: [-1,3,-1]
 * Explanation:
 *     For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
 *     For number 1 in the first array, the next greater number for it in the second array is 3.
 *     For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
 *
 *
 * Example 2:
 *
 * Input: nums1 = [2,4], nums2 = [1,2,3,4].
 * Output: [3,-1]
 * Explanation:
 *     For number 2 in the first array, the next greater number for it in the second array is 3.
 *     For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
 */
public class NextGreaterElement {
	public static void main(String[] args) {
		// 暴力枚举法
		int[] nums1 = new int[] { 4, 1, 2 };
		int[] nums2 = new int[] { 1, 3, 4, 2 };
		CommonUtil.printArray(getResult1(nums1, nums2));
		nums1 = new int[] { 2, 4 };
		nums2 = new int[] { 1, 2, 3, 4 };
		CommonUtil.printArray(getResult1(nums1, nums2));
		// 优化1
		nums1 = new int[] { 4, 1, 2 };
		nums2 = new int[] { 1, 3, 4, 2 };
		CommonUtil.printArray(getResult2(nums1, nums2));
		nums1 = new int[] { 2, 4 };
		nums2 = new int[] { 1, 2, 3, 4 };
		CommonUtil.printArray(getResult2(nums1, nums2));
		// 优化2
		nums1 = new int[] { 4, 1, 2 };
		nums2 = new int[] { 1, 3, 4, 2 };
		CommonUtil.printArray(getResult3(nums1, nums2));
		nums1 = new int[] { 2, 4 };
		nums2 = new int[] { 1, 2, 3, 4 };
		CommonUtil.printArray(getResult3(nums1, nums2));
	}

	/**
	 * 暴力枚举:遍历子集合中的每一个数字，然后在原数组中找到这个数字，然后向右遍历，找到第一个大于该数字的数即可
	 * 时间复杂度o(n*n)
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	private static int[] getResult1(int[] nums1, int[] nums2) {
		int[] result = new int[nums1.length];
		for (int i = 0; i < nums1.length; i++) {
			result[i] = -1;
			int j = 0;
			for (; j < nums2.length; j++) {
				if (nums1[i] == nums2[j]) {
					break;
				}
			}
			int k = j + 1;
			for (; k < nums2.length; k++) {
				if (nums2[k] > nums2[j]) {
					result[i] = nums2[k];
					break;
				}
			}
		}
		return result;
	}

	/**
	 * 先遍历nums2，将每个数字以及对应的下标位置放在map中，再遍历nums1时，从map中找出该数字在nums2中的位置，并向右继续遍历找出第一个更大的数
	 * 时间复杂度o(n*n)
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	private static int[] getResult2(int[] nums1, int[] nums2) {
		int[] result = new int[nums1.length];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums2.length; i++) {
			map.put(nums2[i], i);
		}
		for (int i = 0; i < nums1.length; i++) {
			result[i] = -1;
			int j = map.get(nums1[i]);
			for (j = j + 1; j < nums2.length; j++) {
				if (nums2[j] > nums1[i]) {
					result[i] = nums2[j];
					break;
				}
			}
		}
		return result;
	}

	/**
	 * 先遍历nums2，将当前数字以及它下一个数字放入一个map，由于遍历过程中需要比较当前数字和之前的数字，因此可以用栈,
	 * 再遍历nums1，并从map中取对应的值，为空的话，返回-1，否则直接返回
	 * 时间复杂度o(n)
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	private static int[] getResult3(int[] nums1, int[] nums2) {
		int[] result = new int[nums1.length];
		Map<Integer, Integer> map = new HashMap<>();
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < nums2.length; i++) {
			// 当栈不为空，并且栈顶元素小于当前元素，表示当前元素就是栈顶元素的下一个更大的元素，将这两个元素放入map中
			if (!stack.empty() && stack.peek() < nums2[i]) {
				map.put(stack.peek(), nums2[i]);
				stack.pop();
			}
			stack.push(nums2[i]);
		}
		for (int i = 0; i < nums1.length; i++) {
			int number = nums1[i];
			result[i] = map.get(number) != null ? map.get(number) : -1;
		}
		return result;
	}
}
