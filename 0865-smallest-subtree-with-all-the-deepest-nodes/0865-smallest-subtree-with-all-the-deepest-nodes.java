/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int height = getHeight(root);

        System.out.println(height);

        return getLCA(root, height);
    }

    private TreeNode getLCA(TreeNode root, int height) {
        if(root == null) return null;

        if(root.left == null && root.right == null) {
            if(height == 1) return root;
            return null;
        }

        TreeNode left = getLCA(root.left, height - 1);
        TreeNode right = getLCA(root.right, height - 1);

        if(left == null) return right;
        if(right == null) return left;

        return root;

    }

    private int getHeight(TreeNode root) {
        if(root == null) return 0;

        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}