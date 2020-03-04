package fourth_twoDimentionalArray;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排列。
 * 输入这样一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class TwoDimentionalArray {
    //思路：从右上角或者左下角开始比较
    public static boolean findNum(int[][] a, int key) {
        if (a.length == 0)
            return false;
        boolean isFind = false;
        int row = 0;
        int column = a[0].length - 1;
        while (row < a.length && column >= 0) {
            if (a[row][column] > key)
                column--;
            else if (a[row][column] < key)
                row++;
            else {
                isFind = true;
                break;
            }
        }
        return isFind;
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        int key = 7;
        System.out.println(findNum(a, key));
    }
}
