package seventh_binaryTree;

import java.util.Stack;

/**
 * 遍历二叉树
 */
public class TraverseBTree {
    // 先序遍历-递归
    public static void preTraverse(Node root) {
        if(root != null) {
            System.out.print(root.data + " ");
            preTraverse(root.left);
            preTraverse(root.right);
        }
    }
    // 中序遍历-递归
    public static void midTraverse(Node root) {
        if(root != null) {
            midTraverse(root.left);
            System.out.print(root.data + " ");
            midTraverse(root.right);
        }
    }
    // 后序遍历-递归
    public static void afterTraverse(Node root) {
        if(root != null) {
            afterTraverse(root.left);
            afterTraverse(root.right);
            System.out.print(root.data+ " ");
        }
    }
    // 先序遍历-非递归
    public static void preTraverse2(Node root) {
        Stack<Node> stack = new Stack<>();
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
    public static void midTraverse2(Node root) {
        Stack<Node> stack = new Stack<>();
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

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
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
    }
}

class Node{
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
    }
}