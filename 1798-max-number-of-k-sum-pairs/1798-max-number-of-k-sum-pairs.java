class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        
        int n = nums.length, i = 0, j = n - 1, count = 0;
        
        while (i < j) {
            int sum = nums[i] + nums[j];
            
            if (sum == k) {
                count++;
                i++;
                j--;
                
            } else if (sum > k) {
                j--;
            } else {
                i++;
            }
        }
        
        return count;
        
    }
}