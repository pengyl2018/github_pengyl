package eleventh_minimunOfRevolvedArray;

/**
 * 求排序后的旋转数组中的最小元素 {1,2,3,4,5}旋转后为{4,5,1,2,3}，最小元素为1.
 * 也有特殊情况：{0,1,1,1,1}旋转后为{1,1,1,0,1}，最小元素为0
 */
public class MiniOfRevolved {
    public static int orderSearch(int[] input, int left, int right) {
        int minumum = input[left];
        for (int i = left; i < right; i++) {
            if (minumum > input[i]) {
                minumum = input[i];
            }
        }
        return minumum;
    }

    public static int getMinimum(int[] input) {
        if (input == null || input.length == 0) {
            return -1;
        }
        int length = input.length;
        int left = 0;
        int right = length - 1;
        int mid = left;
        while (input[left] >= input[right]) {
            if (left + 1 == right) {
                break;
            }

            mid = (left + right) / 2;
            // 出现 {0,1,1,1,1}旋转后为{1,1,1,0,1}，此时不能再用二分查找，只能用顺序查找
            if (input[left] == input[mid] && input[left] == input[right]) {
                return orderSearch(input, left, right);
            }

            if (input[mid] >= input[left]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return input[right];
    }

    public static void main(String[] args) {
        int[] input = {3, 4, 5, 1, 2};
        System.out.println(getMinimum(input));
        int[] input2 = {1, 1, 1, 0, 1};
        System.out.println(getMinimum(input2));
    }
}
