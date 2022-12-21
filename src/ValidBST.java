/*
* TODO - incomplete
* */

public class ValidBST {

    public static boolean isValidBST(TreeNode root) {
        if (root == null) return false;

        return false;
    }

    public static void main(String[] args) {
        // todo
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(17);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        //System.out.println(levelOrder(node1));
        System.out.println(isValidBST(node1));
    }
}
