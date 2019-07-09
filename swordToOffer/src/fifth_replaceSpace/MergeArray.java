package fifth_replaceSpace;

/**
 * 合并数组
 * 有两个排序的数组a1和a2，内存在a1的末尾有足够多的空余空间容纳a2.
 * 请实现一个函数，把a2中的所有数字插入a1中，并且所有的数字是排序的。
 */
public class MergeArray {
    public static void print(int[] a) {
        for(int x : a) {
            System.out.print(x + ",");
        }
    }

    public static int getLength(int[] a) {
        int validLength = 0;
        for (int x : a) {
            if (x != 0) {
                validLength++;
            }
        }
        return validLength;
    }

    /*
    从后往前判断
     */
    public static int[] merge(int[] a1, int[] a2) {
        // 判断a1从哪个下标开始是0
        int validLength = getLength(a1);
        int length2 = a2.length;
        // 初始指向8
        int index1_1 = validLength -1;
        // 初始指向0
        int index1_2 = validLength + length2 - 1;
        // 初始指向7
        int index2 = length2 - 1;
        while (index1_1 >=0 && index2 >= 0) {
            if (a1[index1_1] > a2[index2]) {
                a1[index1_2--] = a1[index1_1--];
            } else {
                a1[index1_2--] = a2[index2--];
            }
        }

        while (index1_1 >= 0) {
            a1[index1_2--] = a1[index1_1--];
        }

        while (index2 >= 0) {
            a1[index1_2--] = a2[index2--];
        }
        return a1;
    }

    public static void main(String[] args) {
        int[] a1 = {1, 3, 4, 6, 8, 0, 0, 0, 0};
        int[] a2 = {2, 5, 7};
        a1= merge(a1, a2);
        print(a1);
    }
}
