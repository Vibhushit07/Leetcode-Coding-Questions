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
class FindElements {

    HashSet<Integer> hs = new HashSet<>();

    private void recover(TreeNode node, int n) {
        if(node == null)
            return;

        hs.add(n);
        node.val = n;
        recover(node.left, 2 * n + 1);
        recover(node.right, 2 * n + 2);
    }

    public FindElements(TreeNode root) {
        recover(root, 0);
    }
    
    public boolean find(int target) {
        return hs.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */