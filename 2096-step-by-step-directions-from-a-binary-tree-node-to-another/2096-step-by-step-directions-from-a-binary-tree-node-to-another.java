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

        StringBuilder lcaToStart = new StringBuilder();
        StringBuilder lcaToDest = new StringBuilder();
        StringBuilder result = new StringBuilder();

        findPath(root, startValue, lcaToStart);
        findPath(root, destValue, lcaToDest);

        int lca = 0;
        while(lca < lcaToStart.length() && lca < lcaToDest.length() &&
            lcaToStart.charAt(lca) == lcaToDest.charAt(lca)) {
            lca++;
        }

        for(int i = 0; i < lcaToStart.length() - lca; i++) {
            result.append('U');
        }

        result.append(lcaToDest.toString().substring(lca));
        return result.toString();
    }
}