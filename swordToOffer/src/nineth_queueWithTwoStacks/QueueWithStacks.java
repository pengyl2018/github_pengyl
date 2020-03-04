package nineth_queueWithTwoStacks;

import java.util.Stack;

/**
 * 用两个栈实现一个队列
 */
public class QueueWithStacks {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    /*
    向队列中放入元素
     */
    public void input(Integer num) {
        stack1.push(num);
    }

    /*
    从队列中取出元素
     */
    public Integer output() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                System.out.println("队列中没有元素了！");
                return -1;
            } else {
                while (!stack1.isEmpty()){
                    Integer n = stack1.pop();
                    stack2.push(n);
                }
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        QueueWithStacks queue = new QueueWithStacks();
        queue.input(3);
        queue.input(4);
        queue.input(5);
        System.out.println(queue.output());
        System.out.println(queue.output());
        System.out.println(queue.output());
        System.out.println(queue.output());
    }
}
