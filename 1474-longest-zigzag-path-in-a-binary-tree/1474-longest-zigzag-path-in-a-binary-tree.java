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
    int maxLen = 0;
    public int longestZigZag(TreeNode root) {
        if(root == null)
            return 0;
        
        zigZagPath(root, false, 0);
        zigZagPath(root, true, 0);

        return maxLen;
    }

    private void zigZagPath(TreeNode root, boolean dir, int len) {
        if(root == null)
            return;

        maxLen = Math.max(maxLen, len);

        if(dir) {
            zigZagPath(root.left, false, len + 1);
            zigZagPath(root.right, true, 1);
        } else {
            zigZagPath(root.right, true, len + 1);
            zigZagPath(root.left, false, 1);
        }
    }
}