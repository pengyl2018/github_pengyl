package priorityqueue;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 滑动窗口的最大值
 * 思路：用一个双端队列记录元素的下标，
 * 1.初始化时，将k个元素放入窗口中，只需考虑右边界，若要放入的元素比窗口中当前元素大，则删除当前元素，然后将元素放入窗口，使得窗口中第一个元素始终是窗口中最大的
 * 2.后面继续放入窗口中时，还要考虑左边界是否越界
 */
public class SlidingWindow {
    // 用来存放返回的结果
    private static List<Integer> result = new ArrayList<>();

    // 用来存放元素的下表
    private static Deque<Integer> win = new LinkedList<>();

    public static void init(int[] element, int k) {
        if (element == null || k <= 0 || k > element.length) {
            return;
        }
        // 右边界
        for (int i = 0; i < k; i++) {
            while (!win.isEmpty() && element[win.peekLast()] < element[i]) {
                win.removeLast();
            }
            win.addLast(i);
        }
        result.add(element[win.peekFirst()]);
    }

    public static void add(int[] element, int k) {
        for (int i = k; i < element.length; i++) {
            // 左边界
            if (!win.isEmpty() && win.peekFirst() <= i - k) {
                win.removeFirst();
            }
            // 右边界
            while (!win.isEmpty() && element[win.peekLast()] < element[i]) {
                win.removeLast();
            }
            win.addLast(i);
            result.add(element[win.peekFirst()]);
        }
    }

    public static void main(String[] args) {
        int[] elements = new int[]{2, 5, 2, 4, 5, 7, 1, 5};
        int k = 3;
        init(elements, k);
        add(elements, k);
        System.out.println(result.toString());
    }
}
