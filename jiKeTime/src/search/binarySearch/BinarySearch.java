package search.binarySearch;

/**
 * 五种二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] a = {1, 3, 6, 9, 14, 23, 54};
        System.out.println("9的位置" + binary1(a, 9));
        int[] b = {1, 3, 6, 7, 7, 7, 7, 7, 9, 10};
        System.out.println("第一个7的位置：" + binary2(b, 7));
        System.out.println("最后一个7的位置：" + binary3(b, 7));
        int[] c = {1, 3, 5, 9, 14, 21, 30, 41};
        System.out.println("第一个大于等于6的位置：" + binary4(c, 6));
        System.out.println("最后一个小于等于6的位置：" + binary5(c, 6));
    }

    // 第一种，等值查找，元素无重复
    public static int binary1(int[] a, int elem) {
        int low = 0;
        int high = a.length - 1;
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (a[mid] > elem) {
                high = mid - 1;
            } else if (a[mid] < elem) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    // 第二种，等值查找，找第一个相等的元素，元素有重复
    public static int binary2(int[] a, int elem) {
        int low = 0;
        int high = a.length - 1;
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (a[mid] > elem) {
                high = mid - 1;
            } else if (a[mid] < elem) {
                low = mid + 1;
            } else {
                if (mid == 0 || (a[mid - 1] != elem)) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    // 第三种，等值查找，找最后一个相等的元素，元素有重复
    public static int binary3(int[] a, int elem) {
        int low = 0;
        int high = a.length - 1;
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (a[mid] > elem) {
                high = mid - 1;
            } else if (a[mid] < elem) {
                low = mid + 1;
            } else {
                if (mid == a.length - 1 || (a[mid + 1] != elem)) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    // 第四种，范围查找，找最后一个大于等于某个值的元素，元素有重复
    public static int binary4(int[] a, int elem) {
        int low = 0;
        int high = a.length - 1;
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (a[mid] >= elem) {
                if (mid == 0 || (a[mid - 1] < elem)) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    // 第五种，范围查找，找第一个小于等于某个值的元素，元素有重复
    public static int binary5(int[] a, int elem) {
        int low = 0;
        int high = a.length - 1;
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (a[mid] <= elem) {
                if (mid == a.length - 1 || (a[mid + 1] > elem)) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
