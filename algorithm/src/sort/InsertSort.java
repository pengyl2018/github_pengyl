package sort;

import common.CommonUtil;

import java.util.*;

public class InsertSort {
    public static void insertSort(int[] a) {
        int j, temp, len = a.length;
        for (int i = 1; i < len; i++) {
            if (a[i - 1] > a[i]) {
                temp = a[i];
                for (j = i; j >= 1 && a[j - 1] > temp; j -= 1) {
                    a[j] = a[j - 1];
                }
                a[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 12, 76, 23, 17, 8, 54};
        insertSort(a);
        CommonUtil.printArray(a);
    }
}

