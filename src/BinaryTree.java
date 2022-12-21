/*
* Binary Tree Level Order Traversal and Max Depth
* https://leetcode.com/problems/binary-tree-level-order-traversal/
* https://leetcode.com/problems/maximum-depth-of-binary-tree/
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

        System.out.println(levelOrder(node1));
        //System.out.println(maxDepth(node1));
    }

}
