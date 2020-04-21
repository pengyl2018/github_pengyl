package sort;

import java.util.*;

public class HeapSort {
    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void heapSort(int[] a) {
        buildMaxHeap(a); // 构造大顶堆
        for (int i = a.length - 1; i > 0; i--) {
            swap(a, i, 0);   // 将顶元素和当前最后一个元素交换位置
            adjustDown(a, 0, i); // 从顶元素开始向下进行调整
        }
    }

    public static void buildMaxHeap(int[] a) {
        int len = a.length;
        // 构造大顶堆时，第一个要比较的元素下标正好是(数组长度-1)/2
        for (int i = (len - 1) / 2; i >= 0; i--) {
            adjustDown(a, i, len);
        }
    }

    public static void adjustDown(int[] a, int i, int len) {
        int temp = a[i];
        // 下标为i的元素的左右孩子节点分别是2*i+1和2*i+2
        for (int j = 2 * i + 1; j < len; j = 2 * j + 1) {
            // 判断下标是否越界的判断要放在前面
            if (j + 1 < len && a[j + 1] > a[j])
                j++;
            if (a[j] <= temp) {
                break;
            } else {
                a[i] = a[j];
                i = j;
            }
        }
        a[i] = temp;
    }

    public static void main(String[] args) {
        int[] a = {3, 12, 76, 23, 17, 8, 54};
        heapSort(a);
        System.out.println(Arrays.toString(a));
    }
}
