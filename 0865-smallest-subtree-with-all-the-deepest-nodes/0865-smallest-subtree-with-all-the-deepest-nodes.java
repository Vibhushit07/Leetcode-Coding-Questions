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

    class Result {
        int height;
        TreeNode node;
        Result(int height, TreeNode node) {
            this.height = height;
            this.node = node;
        }
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {

        return getLCA(root).node;
    }

    private Result getLCA(TreeNode root) {
        if(root == null) return new Result(0, null);

        if(root.left == null && root.right == null) {
            return new Result(1, root);
        }

        Result left = getLCA(root.left);
        Result right = getLCA(root.right);

        int height = 1 + Math.max(left.height, right.height);

        if(left.height == right.height) return new Result(height, root);

        if(left.height > right.height) return new Result(height, left.node);

        return new Result(height, right.node);

    }
}