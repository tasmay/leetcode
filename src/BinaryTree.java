/*
* Problems in this set:
* https://leetcode.com/problems/binary-tree-level-order-traversal/
* https://leetcode.com/problems/maximum-depth-of-binary-tree/
* https://leetcode.com/problems/same-tree/
* https://leetcode.com/problems/diameter-of-binary-tree/
* */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            ArrayList<Integer> sublist = new ArrayList<Integer>();
            int size = queue.size();
            for(int i=0; i<size; i++) {
                TreeNode current = queue.poll();
                sublist.add(current.val);
                if(current.left != null) queue.add(current.left);
                if(current.right != null) queue.add(current.right);
            }
            result.add(sublist);
        }
        return result;
    }

    // A binary tree's maximum depth is the number of nodes along the longest
    // path from the root node down to the farthest leaf node.
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            depth += 1;
            int size = queue.size();
            for(int i=0; i<size; i++) {
                TreeNode current = queue.poll();
                if(current.left != null) queue.add(current.left);
                if(current.right != null) queue.add(current.right);
            }
        }
        return depth;
    }

    // height of a tree => number of edges from root to the lowest leaf node
    public static int height(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    // The diameter of a tree is the maximum length of a path between two leaf nodes
    public static int diameter(TreeNode root) {

        return 0;
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;
        if(isSameTree(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static boolean isValidBST(TreeNode root, long minValue, long maxValue) {
        if(root == null) return true;
        if(root.val >= maxValue || root.val <= minValue) return false;
        return isValidBST(root.left, minValue, root.val) && isValidBST(root.right, root.val, maxValue);
    }

    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static ArrayList<Integer> inorder(TreeNode node, ArrayList<Integer> arr) {
        if(node == null) return arr;
        inorder(node.left, arr);
        arr.add(node.val);
        inorder(node.right, arr);
        return arr;
    }

    public static int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
        return nums.get(k-1);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
        return nums;
    }

    public static void main(String[] args) {
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
        //System.out.println(maxDepth(node1));
        //System.out.println(height(node1));

        TreeNode t1 = new TreeNode(20);
        TreeNode t2 = new TreeNode(15);
        TreeNode t3 = new TreeNode(17);
        t1.left = t2;
        t1.right = t3;
//        TreeNode s1 = new TreeNode(4);
//        TreeNode s2 = new TreeNode(3);
//        TreeNode s3 = new TreeNode(5);
//        s1.left = s2;
//        s1.right = s3;
        System.out.println(isSubtree(node1,t1));
    }

}
