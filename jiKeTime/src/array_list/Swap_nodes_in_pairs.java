package array_list;

/**
 * 两两交换链表中的节点
 */
public class Swap_nodes_in_pairs {
    public static ListNode swapList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapList(next.next);
        next.next = head;
        return next;
    }

    public static void main(String[] args) {
        ListNode head = ListUtil.initialList(new int[]{1, 2, 3, 4});
        head = swapList(head);
        ListUtil.printList(head);
        System.out.println("==========");
        head = ListUtil.initialList(new int[]{1, 2, 3, 4, 5});
        head = swapList(head);
        ListUtil.printList(head);
    }
}
