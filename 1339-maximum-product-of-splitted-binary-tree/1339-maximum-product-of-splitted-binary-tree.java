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

    long totalSum = 0;
    List<Long> allSums = new ArrayList<>();

    public int maxProduct(TreeNode root) {
        totalSum = calculateSum(root);
        long maxProd = 1L;

        for(long sum : allSums) {
            maxProd = Math.max(sum * (totalSum - sum), maxProd);
        }

        return (int) (maxProd % 1_000_000_007);
    }

    private long calculateSum(TreeNode root) {
        if(root == null) return 0;

        long currSum = root.val 
            + calculateSum(root.left)
            + calculateSum(root.right);

        allSums.add(currSum);

        return currSum;
    }
}