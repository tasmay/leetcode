import com.sun.source.tree.Tree;

public class InvertBinaryTree {

    public static TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(5);
        t1.left = t2;
        t1.right = t3;
        invertTree(t1);
        System.out.println();
    }
}
