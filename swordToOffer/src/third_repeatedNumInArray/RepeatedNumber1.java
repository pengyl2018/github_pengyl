package third_repeatedNumInArray;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出数组中重复的数字
 * 输入长度为7的数组{2,3,1,0,2,5,3}，那么对应输出的是重复的数字2或者3
 */
public class RepeatedNumber1 {
    public static void swap(Integer[] numbers, int a, int b) {
        int tmp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = tmp;
    }

    public static List<Integer> getRepeatedNum(Integer[] numbers) {
        List<Integer> repeatedNum = new ArrayList<>();
        int len = numbers.length;
        if (len == 0) {
            return repeatedNum;
        }
        for (int i = 0; i < len; i++) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    repeatedNum.add(numbers[i]);
                }
                swap(numbers, i, numbers[i]);
            }
        }
        return repeatedNum;
    }

    public static void main(String[] args) {
        Integer[] numbers = {2, 3, 1, 0, 2, 5, 3};
        List<Integer> repeatedNum = getRepeatedNum(numbers);
        System.out.println(repeatedNum.toString());
    }
}
