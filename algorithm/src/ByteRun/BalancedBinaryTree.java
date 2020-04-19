package ByteRun;

import common.BinaryTree;

/**
 * Given a binary tree, determine if it is height-balanced.
 * <p>
 * For this problem, a height-balanced binary tree is defined as:
 * <p>
 * a binary tree in which the depth of the two subtrees of everynode never differ by more than 1.
 * <p>
 * Example 1:
 * <p>
 * Given the following tree [3,9,20,null,null,15,7]:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * Return true.
 * <p>
 * Example 2:
 * <p>
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 * <p>
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * Return false.
 */
public class BalancedBinaryTree {
    public static void main(String[] args) {
        // 类说明中第一个例子
        BinaryTree b1 = new BinaryTree(3);
        BinaryTree b2 = new BinaryTree(9);
        BinaryTree b3 = new BinaryTree(20);
        BinaryTree b4 = new BinaryTree(15);
        BinaryTree b5 = new BinaryTree(7);
        b1.left = b2;
        b1.right = b3;
        b3.left = b4;
        b3.right = b5;
        System.out.println(isBalanced(b1));
        // 类说明中第二个例子
        b1 = new BinaryTree(1);
        b2 = new BinaryTree(2);
        b3 = new BinaryTree(2);
        b4 = new BinaryTree(3);
        b5 = new BinaryTree(3);
        BinaryTree b6 = new BinaryTree(4);
        BinaryTree b7 = new BinaryTree(4);
        b1.left = b2;
        b1.right = b3;
        b2.left = b4;
        b2.right = b5;
        b4.left = b6;
        b4.right = b7;
        System.out.println(isBalanced(b1));
    }

    private static boolean isBalanced(BinaryTree bt) {
        if (bt == null) {
            return true;
        }
        if (Math.abs(getDepth(bt.left) - getDepth(bt.right)) > 1) {
            return false;
        }
        return isBalanced(bt.left) && isBalanced(bt.right);
    }

    private static int getDepth(BinaryTree bt) {
        if (bt == null) {
            return 0;
        }
        return 1 + Math.max(getDepth(bt.left), getDepth(bt.right));
    }
}
