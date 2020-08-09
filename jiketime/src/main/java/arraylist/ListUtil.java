package arraylist;

public class ListUtil {
    // 初始化一个单链表
    public static ListNode initialList(int[] arr) {
        ListNode node = new ListNode(arr[0]);
        ListNode head = node;
        for (int i = 1; i < arr.length; i++) {
            ListNode nextNode = new ListNode(arr[i]);
            node.next = nextNode;
            node = nextNode;
        }
        return head;
    }

    // 初始化一个环形链表
    public static ListNode initialCycle(int[] arr) {
        ListNode node = new ListNode(arr[0]);
        ListNode head = node;
        for (int i = 1; i < arr.length; i++) {
            ListNode nextNode = new ListNode(arr[i]);
            node.next = nextNode;
            node = nextNode;
        }
        node.next = head.next;
        return head;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }
}
