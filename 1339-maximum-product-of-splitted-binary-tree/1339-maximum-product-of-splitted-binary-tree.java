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

    public int maxProduct(TreeNode root) {
        long totalSum = calculateSum(root);
        long[] maxProd = new long[]{1L};

        findMaxProd(root, totalSum, maxProd);

        return (int) (maxProd[0] % 1_000_000_007);
    }

    private long calculateSum(TreeNode root) {
        if(root == null) return 0;

        long currSum = root.val 
            + calculateSum(root.left)
            + calculateSum(root.right);

        return currSum;
    }

    private long findMaxProd(TreeNode root, long totalSum, long[] maxProd) {
        if(root == null) return 0;

        long currSum = root.val 
            + findMaxProd(root.left, totalSum, maxProd)
            + findMaxProd(root.right, totalSum, maxProd);

        maxProd[0] = Math.max(currSum * (totalSum - currSum), maxProd[0]);

        return currSum;
    }
}