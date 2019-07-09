package fifth_replaceSpace;

/**
 * 实现一个函数，把字符串中的每个空格替换成“%20”。例如，输入“we are happy.”，则输出“we%20are%20happy.”。
 */
public class ReplaceSpace {
    // 查找空格数量
    public static int numofspace(String str) {
        int count = 0;
        for(int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }
        return count;
    }

    // 产生一个新的字符数组，其长度为原有数组长度+空格数*2
    public static char[] copyCharArr(char[] oldArray, int length) {
        char[] newArray = new char[length];
        for (int i = 0; i < oldArray.length; i++) {
            newArray[i] = oldArray[i];
        }
        return newArray;
    }

    // 思路：用两个指针，一个指向原始字符串末尾，另一个指向替换后的字符串的末尾，初始时，两者相距（2*空格数）的距离。
    // 然后，两指针分别项前扫描，如果第一个指针没遇到空格，则将字符赋值给另一个指针处，两指针分别前移，
    // 如果一个指针遇到空格，该指针前移一个，另一个指针处填上‘%20’三个字符，并前移指针，
    // 结束指示：当两个指针相遇
    public static String replace(String str) {
        int count = numofspace(str);
        int length = str.length();
        int index1 = length - 1;
        int index2 = length + count * 2 - 1;
        char[] strArray = copyCharArr(str.toCharArray(), length + count * 2);
        while (index1 != index2) {
            if (str.charAt(index1) != ' ') {
                strArray[index2--] = strArray[index1--];
            } else {
                index1--;
                strArray[index2--] = '0';
                strArray[index2--] = '2';
                strArray[index2--] = '%';
            }
        }
        return String.valueOf(strArray);
    }

    public static void main(String[] args) {
        String str = "we are happy.";
        System.out.println(replace(str));
    }
}
