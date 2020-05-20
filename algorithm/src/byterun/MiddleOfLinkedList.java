package byterun;

import common.CommonUtil;
import common.ListNode;

/**
 * Given a non-empty, singly linked list with head node `head`, return a middle node of linked list.
 * If there are two middle nodes, return the second middle node.
 * <p>
 * Input: [1,2,3,4,5]
 * Output: Node 3
 * <p>
 * Input: [1,2,3,4,5,6]
 * Output: Node 4
 */
public class MiddleOfLinkedList {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        CommonUtil.printNumber(getMiddleNode(n1).val);
        n1 = new ListNode(1);
        n2 = new ListNode(2);
        n3 = new ListNode(3);
        n4 = new ListNode(4);
        n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        CommonUtil.printNumber(getMiddleNode(n1).val);
    }

    /**
     * 双指针法
     * @param head
     * @return
     */
    private static ListNode getMiddleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
