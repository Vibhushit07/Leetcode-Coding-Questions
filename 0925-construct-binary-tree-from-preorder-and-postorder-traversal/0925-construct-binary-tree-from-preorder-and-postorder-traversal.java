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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        if(preorder.length == 0 || postorder.length == 0)
            return null;
        return buildTree(preorder, postorder, 0, preorder.length - 1, 0);
    }

    private TreeNode buildTree(int[] preorder, int[] postorder, int preS, int preE, int postS) {
        if(preS > preE)
            return null;
        TreeNode root = new TreeNode(preorder[preS]);

        if(preS == preE)
            return root;

        int len = 0;
        while(postorder[postS + len] != preorder[preS + 1]) {
            len++;
        }

        root.left = buildTree(preorder, postorder, preS + 1, preS + len + 1, postS);
        root.right = buildTree(preorder, postorder, preS + len + 2, preE, postS + len + 1);

        return root;
    }
}