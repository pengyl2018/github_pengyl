package ByteRun;

import common.CommonUtil;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        int[] list1 = new int[]{1, 2, 4, 8};
        int[] list2 = new int[]{1, 3, 4, 6};
        int[] result = mergeList(list1, list2);
        CommonUtil.printArray(result);
    }

    private static int[] mergeList(int[] list1, int[] list2) {
        int[] mergelist = new int[list1.length + list2.length];
        int i = 0, j = 0, k = 0;
        while (i < list1.length && j < list2.length) {
            if (list1[i] < list2[j]) {
                mergelist[k++] = list1[i++];
            } else {
                mergelist[k++] = list2[j++];
            }
        }
        while (i < list1.length) {
            mergelist[k++] = list1[i++];
        }
        while (j < list2.length) {
            mergelist[k++] = list2[j++];
        }
        return mergelist;
    }
}
