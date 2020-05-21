package byterun;

import common.CommonUtil;

import java.util.Stack;

/**
 * Given two sequences pushed and popped with distinct values, return true if and only if this could have been the result of a sequence of push and pop operations on an initially empty stack.
 * <p>
 * Example 1:
 * <p>
 * Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * Output: true
 * Explanation: We might do the following sequence:
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * Example 2:
 * <p>
 * Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * Output: false
 * Explanation: 1 cannot be popped before 2.
 */
public class ValidateStackSequences {
    public static void main(String[] args) {
        int[] pushArr = new int[]{1, 2, 3, 4, 5};
        int[] popArr = new int[]{4, 5, 3, 2, 1};
        CommonUtil.printBool(judge(pushArr, popArr));
        pushArr = new int[]{1, 2, 3, 4, 5};
        popArr = new int[]{4, 3, 5, 1, 2};
        CommonUtil.printBool(judge(pushArr, popArr));
    }

    private static boolean judge(int[] pushArr, int[] popArr) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < pushArr.length; i++) {
            stack.push(pushArr[i]);
            while (!stack.isEmpty() && popArr[index] == stack.peek()) {
                stack.pop();
                index++;
            }
        }
        if (stack.empty()) {
            return true;
        } else {
            return false;
        }
    }
}
