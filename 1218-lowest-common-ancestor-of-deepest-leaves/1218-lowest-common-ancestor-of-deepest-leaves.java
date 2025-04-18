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

    class Node {
        TreeNode lca;
        int depth;

        Node(TreeNode lca, int depth) {
            this.lca = lca;
            this.depth = depth;
        }
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return lca(root).lca;
    }

    private Node lca(TreeNode root) {
        if (root == null)
            return new Node(root, 0);

        Node left = lca(root.left);
        Node right = lca(root.right);

        if (left.depth == right.depth) {
            return new Node(root, left.depth + 1);
        } else if (left.depth > right.depth) {
            return new Node(left.lca, left.depth + 1);
        } else {
            return new Node(right.lca, right.depth + 1);
        }
    }
}