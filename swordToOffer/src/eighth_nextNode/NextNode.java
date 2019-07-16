package eighth_nextNode;

/**
 * 1.若当前结点有右子树时，其下一个结点为右子树中最左子结点；
 * 2.若当前结点无右子树时，
 * （1）若当前结点为其父结点的左子结点时，其下一个结点为其父结点；
 * （2）若当前结点为其父结点的右子结点时，继续向上遍历父结点的父结点，
 * 直到找到一个结点是其父结点的左子结点（与（1）中判断相同），该结点即为下一结点。
 */
public class NextNode {
    private class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
        TreeNode parent;
        TreeNode(int value) {
            this.value = value;
        }
    }

    public TreeNode getNextNode(TreeNode node) {
        if (node == null){
            System.out.println("节点为null");
            return null;
        }
        if (node.right != null) {
            node = node.right;
            while(node.left != null) {
                node = node.left;
            }
            return node;
        }
        while (node.parent != null) {
            if (node == node.parent.left) {
                return node.parent;
            }
            node = node.parent;
        }
        return null;
    }

    public void test1() {
        TreeNode node = null;
        TreeNode nextNode = getNextNode(node);
        if(nextNode!=null)
            System.out.println(nextNode.value);
        else
            System.out.println("无下一结点");
    }

    public void test2() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.parent = node1;
        node3.parent = node1;
        node4.left=node1;
        node1.parent=node4;
        TreeNode nextNodeOf1=getNextNode(node1);
        TreeNode nextNodeOf2=getNextNode(node2);
        TreeNode nextNodeOf3=getNextNode(node3);
        TreeNode nextNodeOf4=getNextNode(node4);
        if(nextNodeOf1!=null)
            System.out.println("1结点的下一个结点值为："+nextNodeOf1.value);
        else
            System.out.println("1结点无下一结点");
        if(nextNodeOf2!=null)
            System.out.println("2结点的下一个结点值为："+nextNodeOf2.value);
        else
            System.out.println("2结点无下一结点");
        if(nextNodeOf3!=null)
            System.out.println("3结点的下一个结点值为："+nextNodeOf3.value);
        else
            System.out.println("3结点无下一结点");
        if(nextNodeOf4!=null)
            System.out.println("4结点的下一个结点值为："+nextNodeOf4.value);
        else
            System.out.println("4结点无下一结点");
    }

    public static void main(String[] args) {
        NextNode nextNode = new NextNode();
        System.out.print("test1:");
        nextNode.test1();
        System.out.print("test2:");
        nextNode.test2();
    }
}
