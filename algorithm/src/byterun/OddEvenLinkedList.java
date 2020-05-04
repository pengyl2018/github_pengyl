package byterun;

import common.CommonUtil;
import common.ListNode;

/**
 * 这道题给了我们一个链表，让我们分开奇偶节点，所有奇节点在前，偶节点在后。
 * Example:
 * Given 1->2->3->4->5->NULL,
 * return 1->3->5->2->4->NULL.
 */
public class OddEvenLinkedList {
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
        ListNode newhead = oddEvenLinkedList(n1);
        CommonUtil.printLink(newhead);
    }

    /**
     * 思路：我们可以使用两个指针来做，pre指向奇节点，cur指向偶节点，然后把偶节点cur后面的那个奇节点提前到pre的后面，
     * 然后pre和cur各自前进一步，此时cur又指向偶节点，pre指向当前奇节点的末尾，以此类推直至把所有的偶节点都提前了
     */
    private static ListNode oddEvenLinkedList(ListNode head) {
        ListNode pre = head, cur = head.next;
        while (cur != null && cur.next != null) {
            // 暂存pre的后驱节点，以便odd节点最后一个能找到even节点第一个进行相连
            ListNode tmp = pre.next;
            // 1 -> 3
            pre.next = cur.next;
            // 2 -> 4
            cur.next = cur.next.next;
            // 3 -> 2
            pre.next.next = tmp;
            cur = cur.next;
            pre = pre.next;
        }
        return head;
    }
}
