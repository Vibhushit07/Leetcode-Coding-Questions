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
    public int sumRootToLeaf(TreeNode root) {
        int[] sum = new int[]{0};
        binary(root, sum, new StringBuilder());
        return sum[0];
    }

    private void binary(TreeNode root, int[] sum, StringBuilder bin) {
        if(root == null) {
            return;
        }

        bin.append(root.val);

        if(root.left == null && root.right == null) {
            sum[0] += Integer.parseInt(bin.toString(), 2);
            bin.deleteCharAt(bin.length() - 1);
            return;
        }

        binary(root.left, sum, bin);
        binary(root.right, sum, bin);
        bin.deleteCharAt(bin.length() - 1);
    }
}