/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }

        if(root == p || root == q) {
            return root;
        }

        TreeNode leftCA = lowestCommonAncestor(root.left, p, q);
        TreeNode rightCA = lowestCommonAncestor(root.right, p, q);

        if(leftCA != null && rightCA != null) 
            return root;

        return leftCA != null ? leftCA : rightCA;
    }
}