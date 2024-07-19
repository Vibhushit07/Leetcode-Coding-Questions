class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int len = 0, j = -1, n = nums.length;
        
        for(int i = 0; i < n; i++) {
            if(nums[i] != 1) {
                int l = i - j - 1;
                j = i;
                
                len = Math.max(len, l);
            }
        }
        
        int l = n - j - 1;
        len = Math.max(len, l);
        
        return len;
    }
}