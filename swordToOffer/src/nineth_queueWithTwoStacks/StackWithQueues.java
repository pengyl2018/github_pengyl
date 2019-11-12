package nineth_queueWithTwoStacks;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用两个队列实现栈
 */
public class StackWithQueues {
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    public void input(Integer num) {
        if (queue1.isEmpty()) {
            queue2.offer(num);
        } else {
            queue1.offer(num);
        }
    }

    public Integer output() {
        if (queue1.isEmpty()) {
            if (queue2.isEmpty()) {
                System.out.println("栈已经空了！");
                return -1;
            }
            while (queue2.size() > 1) {
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        } else {
            if (queue1.isEmpty()) {
                System.out.println("栈已经空了！");
                return -1;
            }
            while (queue1.size() > 1) {
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        }
    }
    public static void main(String[] args) {
        StackWithQueues stack = new StackWithQueues();
        stack.input(1);
        stack.input(2);
        stack.input(3);
        System.out.println(stack.output());
        System.out.println(stack.output());
        stack.input(4);
        System.out.println(stack.output());
        System.out.println(stack.output());
        System.out.println(stack.output());
    }
}
