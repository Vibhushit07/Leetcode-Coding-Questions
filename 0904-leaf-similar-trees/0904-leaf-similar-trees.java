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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        checkLeaf(root1, q1);
        checkLeaf(root2, q2);

        if(q1.size() != q2.size()) {
            return false;
        }

        while(!q1.isEmpty() && !q2.isEmpty()) {
            int a = q1.poll();
            int b = q2.poll();
            if(a != b) {
                return false;
            }
        }

        return true;
    }

    private void checkLeaf(TreeNode root, Queue<Integer> q) {
        if(root == null)
            return;
        if(root.left == null && root.right == null) {
            q.add(root.val);
            return;
        }

        checkLeaf(root.left, q);
        checkLeaf(root.right, q);
    }
}