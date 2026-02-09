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

    private void inorderTraversal(TreeNode root, List<Integer> inorder) {
        if(root == null) return;

        inorderTraversal(root.left, inorder);
        inorder.add(root.val);
        inorderTraversal(root.right, inorder);
    }

    private TreeNode buildTree(List<Integer> inorder, int left, int right) {
        if(left > right) return null;

        int mid = left + (right - left) / 2;

        TreeNode node = new TreeNode(inorder.get(mid));
        node.left = buildTree(inorder, left, mid - 1);
        node.right = buildTree(inorder, mid + 1, right);

        return node;
    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();

        inorderTraversal(root, inorder);

        return buildTree(inorder, 0, inorder.size() - 1);
    }
}