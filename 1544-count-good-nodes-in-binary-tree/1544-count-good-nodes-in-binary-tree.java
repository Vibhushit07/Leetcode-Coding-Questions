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
    public int goodNodes(TreeNode root) {
        if(root == null)
            return 0;

        return count(root, root.val);
    }

    private int count(TreeNode root, int max) {
        if(root == null) 
            return 0;

        return max > root.val ?
            count(root.left, max) + count(root.right, max) : 
            1 +  count(root.left, root.val) + count(root.right, root.val);
    }
}