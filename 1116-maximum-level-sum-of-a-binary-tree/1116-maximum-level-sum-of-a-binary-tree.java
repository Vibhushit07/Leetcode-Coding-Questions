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
    public int maxLevelSum(TreeNode root) {

        if(root == null) return -1;

        Queue<TreeNode> q = new LinkedList<>();

        int level = 1, maxLevel = 1, sum = 0, maxSum = Integer.MIN_VALUE;

        q.add(root);
        q.add(null);

        while(!q.isEmpty()) {
            TreeNode n = q.remove();
            
            if(n != null) {
                sum += n.val;
                if(n.left != null)
                    q.add(n.left);
                if(n.right != null)
                    q.add(n.right);

            } else {
                if(maxSum < sum) {
                    maxSum = sum;
                    maxLevel = level;
                }
                sum = 0;
                level++;

                if(!q.isEmpty())
                    q.add(null);
            }
        }

        return maxLevel;
    }
}