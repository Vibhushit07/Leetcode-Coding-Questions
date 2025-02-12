// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
class Solution {

    private int count;
    private HashMap<Long, Integer> hm;

    public int pathSum(TreeNode root, int targetSum) {

        hm = new HashMap<>();
        count = 0;

        if(root == null)
            return 0;
        
        dfs(root, targetSum, 0L);
        return count;
    }

    private void dfs(TreeNode root, int targetSum, long sum) {
        if(root == null)
            return;
        
        sum += root.val;
        // System.out.println(root.val + " " + sum);

        if(sum == targetSum) {
            count++;
            // System.out.println(root.val + " " + sum + " " + count);
        }

        // System.out.println(hm);
        if (hm.containsKey(sum-targetSum)) {
            // System.out.println("inside");
            count += hm.get(sum-targetSum);
        }

        // count += hm.getOrDefault(sum - targetSum, 0);

        hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        
        // System.out.println("Left");
        dfs(root.left, targetSum, sum);
        // System.out.println("Right");
        dfs(root.right, targetSum, sum);
        // System.out.println("Done");
        hm.put(sum, hm.get(sum) - 1);
    }
}

// class Solution {

//     private Map<Long, Integer> hmap;
//     private int count;

//     public int pathSum(TreeNode root, int targetSum) {
//         hmap = new HashMap<>();
//         count = 0;

//         dfs(root, 0, targetSum);

//         return count;
//     }

//     private void dfs(TreeNode root, long prefixSum, int targetSum) {
//         if (root == null) return;
        
//         prefixSum += root.val;
        
//         if (hmap.containsKey(prefixSum-targetSum)) 
//             count += hmap.get(prefixSum-targetSum); 
        
//         if (targetSum == prefixSum) 
//             count++;

//         hmap.put(prefixSum, hmap.getOrDefault(prefixSum, 0) + 1);

//         dfs(root.left, prefixSum, targetSum);
//         dfs(root.right, prefixSum, targetSum);

//         hmap.put(prefixSum, hmap.get(prefixSum) - 1);
//     }
// }
