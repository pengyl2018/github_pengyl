package array_list;

/**
 * 反转链表
 */
public class Reverse_linked_list {
    public static ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = ListUtil.initialList(new int[] {1,2,3,4,5});
        ListUtil.printList(head);
        System.out.println("=============");
        head = reverseList(head);
        ListUtil.printList(head);
    }
}
