package ByteRun;

import common.CommonUtil;
import common.ListNode;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * <p>
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * <p>
 * Example:
 * <p>
 * Given this linked list: 1->2->3->4->5
 * <p>
 * For k = 2, you should return: 2->1->4->3->5
 * <p>
 * For k = 3, you should return: 3->2->1->4->5
 * <p>
 * Note:
 * <p>
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 */
public class ReverseNodesInkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        ListNode preTmp = new ListNode(-1);
        preTmp.next = head;
        ListNode pre = preTmp;
        int count = 0;
        while (cur != null) {
            count++;
            if (count < k) {
                cur = cur.next;
            } else {
                // tmpHead为当前组列表的第一个元素，待翻转后，此元素变为该列表最后一个元素
                ListNode tmpHead = pre.next;
                // 保留当前组列表的后续元素的指针，防止当前组元素翻转后找不到后续元素
                ListNode next = cur.next;
                cur.next = null;
                // 当前组列表翻转后，向前与pre相关联
                pre.next = reverseList(tmpHead);
                // 当前组列表翻转后，向后与next关联
                tmpHead.next = next;
                pre = tmpHead;
                cur = next;
                count = 0;
            }
        }
        // 不能return head，因为head此时指向的是第一组数字翻转后最后一位
        return preTmp.next;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            // 保留后面一位的指针，防止当前位置指针指向前面元素后，与后面元素断开挂接
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next = null;
        return pre;
    }

    public static void main(String[] args) {
        ReverseNodesInkGroup test = new ReverseNodesInkGroup();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode head = test.reverseKGroup(n1, 2);
        CommonUtil.printLink(head);
    }
}
