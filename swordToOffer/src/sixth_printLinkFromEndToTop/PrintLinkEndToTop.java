package sixth_printLinkFromEndToTop;

import java.util.Stack;

/**
 * 从尾到头打印链表
 */
public class PrintLinkEndToTop {
    /*
    使用栈结构
     */
    public static void printListNode(ListNode root){
        Stack<Integer> stack = new Stack<>();
        while (root != null) {
            stack.push(root.data);
            root = root.next;
        }

        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode();
        node.data = 1;
        ListNode node2 = new ListNode();
        node2.data = 2;
        ListNode node3 = new ListNode();
        node3.data = 3;
        node.next = node2;
        node2.next = node3;
        printListNode(node);
    }
}

class ListNode {
    int data;
    ListNode next;
}