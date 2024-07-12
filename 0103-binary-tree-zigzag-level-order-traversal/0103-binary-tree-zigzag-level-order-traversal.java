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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        if(root == null) {
            return new ArrayList<>();
        }
        
        Stack<TreeNode> slr = new Stack<>();
        Stack<TreeNode> srl = new Stack<>();
        
        slr.push(root);
        int i = 0;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        while(!slr.isEmpty() || !srl.isEmpty()) {
            
            ArrayList<Integer> lr = new ArrayList<>();
            ArrayList<Integer> rl = new ArrayList<>();
            
            while(!slr.isEmpty()) {
                TreeNode node = slr.pop();
                
                lr.add(node.val);
                
                if(node.left != null) {
                    srl.push(node.left);
                }
                
                if(node.right != null) {
                    srl.push(node.right);
                }
                    
            }
            
            while(!srl.isEmpty()) {
                TreeNode node = srl.pop();
                
                rl.add(node.val);
                
                if(node.right != null) {
                    slr.push(node.right);
                }
                
                if(node.left != null) {
                    slr.push(node.left);
                }
                    
            }
            
            if(lr.size() != 0) {
                res.add(lr);
            }
            
            if(rl.size() != 0) {
                res.add(rl);
            }
        }
        return res;
    }
}