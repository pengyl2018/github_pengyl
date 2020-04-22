package sort;

import common.CommonUtil;

import java.util.*;

public class QuickSort {
    public static void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int pivotIndex = partion(a, low, high);
            quickSort(a, low, pivotIndex - 1);
            quickSort(a, pivotIndex + 1, high);
        }
    }

    public static int partion(int[] a, int low, int high) {
        int temp = a[low];
        while (low < high) {
            while (low < high && a[high] >= temp) high--;
            a[low] = a[high];
            while (low < high && a[low] <= temp) low++;
            a[high] = a[low];
        }
        a[low] = temp;
        return low;
    }

    public static void main(String[] args) {
        int[] a = {3, 12, 76, 23, 17, 8, 54};
        quickSort(a, 0, a.length - 1);
        CommonUtil.printArray(a);
    }
}
