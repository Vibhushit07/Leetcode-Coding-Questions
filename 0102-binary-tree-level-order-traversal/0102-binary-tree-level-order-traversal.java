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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        
		List<Integer> list1 = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
        q.add(null);
		
        while(!q.isEmpty()) {
			TreeNode temp = q.poll();
			if(temp == null) {
				list.add(new ArrayList<>(list1));
				list1.clear();
		if(!q.isEmpty())
				    q.add(null);
			} else {
				list1.add(temp.val);
				if(temp.left != null) {
					q.add(temp.left);
				}
				if(temp.right != null) {
					q.add(temp.right);
				}
			}
		}
		return list;
    }
}