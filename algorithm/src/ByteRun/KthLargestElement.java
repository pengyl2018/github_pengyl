package ByteRun;

import common.CommonUtil;

/**
 * 求第k大的元素（可以采用堆排序，维护一个大小为k的小顶堆，遍历完之后，堆顶元素就是第k大的）
 * 默认k小于数组大小
 */
public class KthLargestElement {
    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int k = 3;
        int result = getKthElement(input, k);
        CommonUtil.printNumber(result);
    }

    private static int getKthElement(int[] input, int k) {
        // 构建小顶堆
        int[] heapArray = new int[k];
        System.arraycopy(input, 0, heapArray, 0, k);
        buildMinHeap(heapArray);
        // 遍历数组中每个元素，与堆顶元素比较，比堆顶大的元素，覆盖堆顶，并重新保持堆
        for (int i = k; i < input.length; i++) {
            if (input[i] > heapArray[0]) {
                heapArray[0] = input[i];
                adjustDown(heapArray, 0, k);
            }
        }
        return heapArray[0];
    }

    private static void buildMinHeap(int[] input) {
        int length = input.length;
        for (int i = (length - 1) / 2; i >= 0; i--) {
            adjustDown(input, i, length);
        }
    }

    private static void adjustDown(int[] input, int i, int length) {
        int temp = input[i];
        for (int j = 2 * i + 1; j < length; j = j * 2 + 1) {
            if (j + 1 < length && input[j] > input[j + 1]) {
                j++;
            }
            if (input[j] >= temp) {
                break;
            } else {
                input[i] = input[j];
                i = j;
            }
        }
        input[i] = temp;
    }
}
