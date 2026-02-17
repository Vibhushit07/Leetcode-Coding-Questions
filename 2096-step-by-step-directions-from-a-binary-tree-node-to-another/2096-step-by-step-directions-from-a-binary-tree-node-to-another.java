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

    private TreeNode getLCA(TreeNode root, int startValue, int destValue) {
        if(root == null || root.val == startValue || root.val == destValue) 
            return root;
            
        TreeNode left = getLCA(root.left, startValue, destValue);
        TreeNode right = getLCA(root.right, startValue, destValue);

        if(left != null && right != null)
            return root;

        return left != null ? left : right;
    }

    private boolean findPath(TreeNode root, int target, StringBuilder path) {
        if(root == null) return false;

        if(root.val == target) return true;

        path.append('L');
        if(findPath(root.left, target, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);

        path.append('R');
        if(findPath(root.right, target, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);

        return false;
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca = getLCA(root, startValue, destValue);

        StringBuilder lcaToStart = new StringBuilder();
        StringBuilder lcaToDest = new StringBuilder();
        StringBuilder result = new StringBuilder();

        findPath(lca, startValue, lcaToStart);
        findPath(lca, destValue, lcaToDest);

        for(int i = 0; i < lcaToStart.length(); i++) {
            result.append('U');
        }

        result.append(lcaToDest);
        return result.toString();
    }
}