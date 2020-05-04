package byterun;

import common.CommonUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 给出一个整数数组，请在数组中找出两个加起来等于目标值的数，
 * 你给出的函数twoSum 需要返回这两个数字的下标（index1，index2），需要满足 index1 小于index2.。注意：下标是从1开始的
 * 假设给出的数组中只存在唯一解
 * 例如：
 * 给出的数组为 {2, 7, 11, 15},目标值为9
 * 输出 ndex1=1, index2=2
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 4};
        int target = 6;
        int[] ints = new TwoSum().twoSum(arr, target);
        CommonUtil.printArray(ints);
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] arr = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(numbers[0], 1);
        for (int i = 1; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                arr[0] = map.get(target - numbers[i]);
                arr[1] = i + 1;
                break;
            } else {
                map.put(numbers[i], i + 1);
            }
        }
        return arr;
    }
}
