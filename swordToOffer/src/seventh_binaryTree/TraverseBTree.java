package seventh_binaryTree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 遍历二叉树
 */
public class TraverseBTree {
    // 先序遍历-递归
    public static void preTraverse(TreeNode root) {
        if(root != null) {
            System.out.print(root.data + " ");
            preTraverse(root.left);
            preTraverse(root.right);
        }
    }
    // 中序遍历-递归
    public static void midTraverse(TreeNode root) {
        if(root != null) {
            midTraverse(root.left);
            System.out.print(root.data + " ");
            midTraverse(root.right);
        }
    }
    // 后序遍历-递归
    public static void afterTraverse(TreeNode root) {
        if(root != null) {
            afterTraverse(root.left);
            afterTraverse(root.right);
            System.out.print(root.data+ " ");
        }
    }
    // 先序遍历-非递归
    public static void preTraverse2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()) {
            while (root != null) {
                System.out.print(root.data + " ");
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                root = root.right;
            }
        }
    }
    // 中序遍历-非递归
    public static void midTraverse2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if(!stack.isEmpty()) {
                root = stack.pop();
                System.out.print(root.data + " ");
                root = root.right;
            }
        }
    }
    // 后序遍历-非递归
    /*
    思路：对于一个节点而言，要实现访问顺序为左儿子-右儿子-根节点，可以利用后进先出的栈，
    在节点不为空的前提下，依次将根节点，右儿子，左儿子压栈。故我们需要按照根节点-右儿子-左
    儿子的顺序遍历树，而我们已经知道先序遍历的顺序是根节点-左儿子-右儿子，故只需将先序遍历
    的左右调换并把访问方式打印改为压入另一个栈即可。最后一起打印栈中的元素。
     */
    public static void afterTraverse2(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        while(root != null || !stack1.isEmpty()) {
            while (root != null) {
                stack1.push(root);
                stack2.push(root);
                root = root.right;
            }
            if (!stack1.isEmpty()) {
                root = stack1.pop();
                root = root.left;
            }
        }
        while (!stack2.isEmpty()) {
            TreeNode n = stack2.pop();
            System.out.print(n.data + " ");
        }
    }

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

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        preTraverse(n1);
        System.out.println();
        midTraverse(n1);
        System.out.println();
        afterTraverse(n1);
        System.out.println();
        preTraverse2(n1);
        System.out.println();
        midTraverse2(n1);
        System.out.println();
        afterTraverse2(n1);
        System.out.println();
        levelTraverse(n1);
    }
}
