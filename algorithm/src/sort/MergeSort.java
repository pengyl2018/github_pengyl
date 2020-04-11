package sort;

import java.util.*;

public class MergeSort {
    public static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int k = 0;
        int l = low;
        int r = mid + 1;
        while (l <= mid && r <= high) {
            if (a[l] <= a[r]) {
                temp[k++] = a[l++];
            } else {
                temp[k++] = a[r++];
            }
        }
        while (l <= mid) {
            temp[k++] = a[l++];
        }
        while (r <= high) {
            temp[k++] = a[r++];
        }
        for (int i = 0; i < temp.length; i++) {
            a[i + low] = temp[i];
        }
    }

    public static void mergeSort(int[] a, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 12, 76, 23, 17, 8, 54};
        mergeSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
