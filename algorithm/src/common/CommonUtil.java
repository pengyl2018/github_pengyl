package common;

import java.util.Arrays;

public class CommonUtil {
    public static void printArray(int[] input) {
        System.out.println(Arrays.toString(input));
    }

    public static void printNumber(int input) {
        System.out.println(input);
    }

    public static void printBool(boolean input) {
        System.out.println(input);
    }

    public static void printStirng(String str) {
        System.out.println(str);
    }

    public static void printLink(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
