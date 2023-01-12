public class LowestCommonAncestor {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        while(curr != null) {
            if(p.val > curr.val && q.val > curr.val)
                curr = curr.right;
            else if (p.val < curr.val && q.val < curr.val)
                curr = curr.left;
            else
                return curr;
        }
        return curr;
    }

    public static void main(String[] args) {

    }
}
