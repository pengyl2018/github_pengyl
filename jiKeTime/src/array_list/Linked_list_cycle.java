package array_list;

import java.util.Set;
import java.util.HashSet;

/**
 * 环形链表(判断一个链表中是否存在环)
 */
public class Linked_list_cycle {
    //双指针
    public static boolean exitCycle1(ListNode head) {
       if (head == null || head.next == null) {
           return false;
       }
       ListNode slow = head;
       ListNode fast = head.next;
       while (slow != fast) {
           if(fast == null || fast.next == null) {
               return false;
           }
           slow = slow.next;
           fast = fast.next.next;
       }
       return true;
    }

    // hash表
    public static boolean exitCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while(head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
                head = head.next;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //初始化单链表
        ListNode head = ListUtil.initialList(new int[] {1,2,3,4,5,6});
        System.out.println(exitCycle1(head));
        System.out.println(exitCycle2(head));
        //初始化环形链表
        head = ListUtil.initialCycle(new int[] {1,2,3,4,5,6});
        System.out.println(exitCycle1(head));
        System.out.println(exitCycle2(head));
    }
}
