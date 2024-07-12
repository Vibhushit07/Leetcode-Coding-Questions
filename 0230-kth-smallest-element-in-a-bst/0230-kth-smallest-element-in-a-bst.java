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
    public int kthSmallest(TreeNode root, int k) {
        
        TreeNode node = root;
        Stack<TreeNode> st = new Stack<>();
        
        while(node != null || !st.isEmpty()) {
            while(node != null) {
                st.push(node);
                node = node.left;
            }
            
            TreeNode temp = st.pop();
            
            if(--k == 0) {
                return temp.val;
            }
            
            node = temp.right;
        }
        
        return -1;
        
    }
}