package ByteRun;

import common.CommonUtil;

import java.util.Stack;

/**
 * 用栈实现队列
 */
public class ImplementQueueByStack {
    private static Stack<String> stack1 = new Stack<>();
    private static Stack<String> stack2 = new Stack<>();

    public static void main(String[] args) {
        pushElement("a");
        pushElement("b");
        CommonUtil.printStirng(getElement());
        CommonUtil.printStirng(popElement());
        CommonUtil.printStirng(popElement());
        CommonUtil.printStirng(popElement());
        pushElement("c");
        CommonUtil.printStirng(popElement());
    }
    
    private static void pushElement(String str) {
        stack1.push(str);
    }
    
    private static String getElement() {
        adjustBeforeGet();
        if (stack2.empty()) {
            return null;
        }
        return stack2.peek();
    }
    
    private static String popElement() {
        adjustBeforeGet();
        if (stack2.empty()) {
            return null;
        }
        return stack2.pop();
    }

    private static void adjustBeforeGet() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
    }
}
