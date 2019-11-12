package seventh_binaryTree;

import java.util.Deque;
import java.util.LinkedList;

/*
重建树：根据先序遍历和中序遍历，构建树
 */
public class ReconstrutTree {
    // 层次遍历
    public static void levelTraverse(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.poll();
            System.out.print(node.data + " ");
            if (node.left != null) {
                deque.offer(node.left);
            }
            if (node.right != null) {
                deque.offer(node.right);
            }
        }
    }

    public static TreeNode initTree(int[] preOrder, int preStart, int preEnd, int[] midOrder, int midStart, int midEnd) {
        if (preStart > preEnd || midStart > midEnd) {
            return null;
        }
        // 第一个节点作为根
        TreeNode root = new TreeNode(preOrder[preStart]);
        // 先序遍历的根,也是中序遍历中间的一个节点
        int midIndex = findMidIndex(preOrder[preStart], midOrder, midStart, midEnd);
        int offset = midIndex - midStart - 1;
        // 构建左子树
        TreeNode leftNode = initTree(preOrder, preStart + 1, preStart + 1 + offset, midOrder, midStart, midStart + offset);
        // 构建右子树
        TreeNode rightNode = initTree(preOrder, preStart + offset + 2, preEnd, midOrder, midIndex + 1, midEnd);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }

    public static int findMidIndex(int rootNum, int[] midOrder, int midStart, int midEnd) {
        for (int i = midStart; i <= midEnd; i++) {
            if (midOrder[i] == rootNum) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // 先序
        int[] preOrder = {1, 2, 4, 5, 3, 6, 7};
        // 中序
        int[] midOrder = {4, 2, 5, 1, 6, 3, 7};
        TreeNode node = initTree(preOrder, 0, preOrder.length - 1, midOrder, 0, midOrder.length - 1);
        levelTraverse(node);
    }
}