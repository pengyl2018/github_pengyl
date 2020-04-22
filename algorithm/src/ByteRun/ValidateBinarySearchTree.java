package ByteRun;

import common.BinaryTree;
import common.CommonUtil;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * Example 1:
 *
 * Input:
 *     2
 *    / \
 *   1   3
 * Output: true
 * Example 2:
 *
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * Output: false
 * Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
 *              is 5 but its right child's value is 4.
 */
public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        // 例子中第一颗树
        BinaryTree b1 = new BinaryTree(1);
        BinaryTree b2 = new BinaryTree(2);
        BinaryTree b3 = new BinaryTree(3);
        b2.left = b1;
        b2.right = b3;
        b1.left = b1.right = null;
        b3.left = b3.right = null;
        CommonUtil.printBool(judgeInvalid(b2));
        // 例子中第二棵树
        b1 = new BinaryTree(1);
        b3 = new BinaryTree(3);
        BinaryTree b4 = new BinaryTree(4);
        BinaryTree b5 = new BinaryTree(5);
        BinaryTree b6 = new BinaryTree(6);
        b5.left = b1;
        b5.right = b4;
        b4.left = b3;
        b4.right = b6;
        CommonUtil.printBool(judgeInvalid(b5));
    }
    private static boolean judgeInvalid(BinaryTree bt) {
        if (bt == null) {
            return false;
        }
        return reverseInvalid(bt, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean reverseInvalid(BinaryTree bt, long low, long high) {
        if (bt == null) {
            return true;
        }
        if (bt.value < low || bt.value > high) {
            return false;
        }
        return reverseInvalid(bt.left, low, bt.value) && reverseInvalid(bt.right, bt.value, high);
    }
}
