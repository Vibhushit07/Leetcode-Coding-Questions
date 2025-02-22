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
    public TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode root = null;
        int i = 0, n = traversal.length();

        while(i < n) {
            int val = 0, dash = 0;

            while(i < n && traversal.charAt(i) == '-') {
                dash++;
                i++;
            }

            while(i < n && traversal.charAt(i) >= '0' && traversal.charAt(i) <= '9') {
                val = val * 10 + (traversal.charAt(i) - '0');
                i++;
            }

            while(!st.isEmpty() && st.size() > dash) {
                st.pop();
            }

            TreeNode node = new TreeNode(val);

            if(st.isEmpty()) {
                root = node;
            } else {
                TreeNode parent = st.peek();
                if(parent.left == null) {
                    parent.left = node;
                } else {
                    parent.right = node;
                }
            }

            st.push(node);

        }

        return root;
    }
}