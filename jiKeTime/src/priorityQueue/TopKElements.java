package priorityQueue;

import java.util.PriorityQueue;

/**
 * 求最大的k个值（使用小顶堆）
 */
public class TopKElements {
    // 优先级队列本身就是小顶堆
    private PriorityQueue<Integer> queue;
    private int k;

    public TopKElements(int k) {
        this.k = k;
        queue = new PriorityQueue<>(k);
    }

    public void add(Integer element) {
        if (queue.size() < k) {
            queue.offer(element);
        } else if (queue.peek() < element) {
            queue.poll();
            queue.offer(element);
        }
    }

    public Integer getTopKLargest() {
        return queue.peek();
    }

    public static void main(String[] args) {
        TopKElements topKElements = new TopKElements(3);
        Integer[] elemArr = new Integer[] {21, 3, 43, 26, 34, 76, 56};
        for (Integer elem : elemArr) {
            topKElements.add(elem);
        }
        System.out.println("第k大的数是" + topKElements.getTopKLargest());
    }
}
