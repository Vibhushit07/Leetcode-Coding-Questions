// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
class Solution {

    private int count;
    private HashMap<Long, Integer> hm;

    public int pathSum(TreeNode root, int targetSum) {

        hm = new HashMap<>();
        count = 0;

        if(root == null)
            return 0;
        
        dfs(root, targetSum, 0L);
        return count;
    }

    private void dfs(TreeNode root, int targetSum, long sum) {
        if(root == null)
            return;
        
        sum += root.val;

        if(sum == targetSum) {
            count++;
        }

        count += hm.getOrDefault(sum - targetSum, 0);

        hm.put(sum, hm.getOrDefault(sum, 0) + 1);
;
        dfs(root.left, targetSum, sum);
        dfs(root.right, targetSum, sum);
        hm.put(sum, hm.get(sum) - 1);
    }
}