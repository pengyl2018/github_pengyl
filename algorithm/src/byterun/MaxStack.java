package byterun;

import common.CommonUtil;

import java.util.Stack;

/**
 * Design a max stack that supports push, pop, top, peekMax and popMax.
 * push(x) -- Push element x onto stack.
 * pop() -- Remove the element on top of the stack and return it.
 * top() -- Get the element on the top.
 * peekMax() -- Retrieve the maximum element in the stack.
 * popMax() -- Retrieve the maximum element in the stack, and remove it. If you find more than one maximum elements, only remove the top-most one.
 * Example 1:
 * <p>
 * MaxStack stack = new MaxStack();
 * stack.push(5);
 * stack.push(1);
 * stack.push(5);
 * stack.top(); -> 5
 * stack.popMax(); -> 5
 * stack.top(); -> 1
 * stack.peekMax(); -> 5
 * stack.pop(); -> 1
 * stack.top(); -> 5
 */
public class MaxStack {
    /**
     * 设置两个栈，一个栈用来存放所有数字，另一个栈用来存放最大数字
     */
    private Stack<Integer> stack_all = new Stack<>();
    private Stack<Integer> stack_max = new Stack<>();

    public static void main(String[] args) {
        MaxStack stack = new MaxStack();
        stack.push(5);
        stack.push(1);
        stack.push(5);
        CommonUtil.printNumber(stack.top());
        CommonUtil.printNumber(stack.popMax());
        CommonUtil.printNumber(stack.top());
        CommonUtil.printNumber(stack.peekMax());
        CommonUtil.printNumber(stack.pop());
        CommonUtil.printNumber(stack.top());
    }

    private void push(int number) {
        stack_all.push(number);
        if (stack_max.isEmpty() || stack_max.peek() <= number) {
            stack_max.push(number);
        }
    }

    private int pop() {
        int num = stack_all.pop();
        if (num == stack_max.peek()) {
            stack_max.pop();
        }
        return num;
    }

    private int top() {
        return stack_all.peek();
    }

    private int peekMax() {
        if (stack_max.isEmpty()) {
            return 0;
        }
        return stack_max.peek();
    }

    /**
     * 先用一个临时栈存放从stack_all取出的数字，直到找到与stack_max栈顶元素相同的那个数字，取出，再将临时栈中的数字放回到stack_all中
     *
     * @return
     */
    private int popMax() {
        int num = stack_max.pop();
        Stack<Integer> tmpStack = new Stack<>();
        while (!stack_all.isEmpty() && stack_all.peek() != num) {
            tmpStack.push(stack_all.pop());
        }
        stack_all.pop();
        while (!tmpStack.isEmpty()) {
            stack_all.push(tmpStack.pop());
        }
        return num;
    }
}
