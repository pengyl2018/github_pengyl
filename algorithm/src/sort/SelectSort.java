package sort;

import common.CommonUtil;

import java.util.*;

public class SelectSort {
    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void selectSort(int[] a) {
        int min, len = a.length;
        for (int i = 0; i < len; i++) {
            min = i;
            for (int j = i + 1; j < len; j++) {
                if (a[j] < a[min])
                    min = j;
            }
            if (min != i) {
                swap(a, i, min);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 12, 76, 23, 17, 8, 54};
        selectSort(a);
        CommonUtil.printArray(a);
    }
}

