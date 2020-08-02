package stack_queue;

import java.util.Stack;

/**
 * 用栈实现队列
 */
public class BuildQueueByStack {
    static Stack<String> inputStack = new Stack<>();
    static Stack<String> outputStack = new Stack<>();

    // 元素入队
    public static void push(String str) {
        inputStack.push(str);
    }

    // 元素出队
    public static String pop() {
        return judgeEmpty() ? "" : outputStack.pop();
    }

    // 取顶元素
    public static String peek() {
        return judgeEmpty() ? "" : outputStack.peek();
    }

    // 判断是否为空
    public static boolean judgeEmpty() {
        if (outputStack.isEmpty()) {
            while (inputStack.isEmpty() == false) {
                outputStack.push(inputStack.pop());
            }
        }
        if (outputStack.isEmpty()) {
            System.out.println("queue is empty");
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        push("1");
        System.out.println(pop());
        push("2");
        push("3");
        System.out.println(pop());
        push("4");
        System.out.println(pop());
        System.out.println(pop());
    }
}
