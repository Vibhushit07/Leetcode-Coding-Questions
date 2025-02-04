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
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> rightView = new ArrayList<>();

        if(root == null) 
            return rightView;

        Queue<TreeNode> nodes = new LinkedList<>();

        nodes.add(root);
        nodes.add(null);

        while(!nodes.isEmpty()) {
            TreeNode node = nodes.poll();

            if(node == null && !nodes.isEmpty()) {
                nodes.add(null);
            } else if(node != null) {
                if(nodes.peek() == null) {
                    rightView.add(node.val);
                } 
                if(node.left != null)
                    nodes.add(node.left);
                if(node.right != null)
                    nodes.add(node.right);
                
            }
        }

        return rightView;
    }
}