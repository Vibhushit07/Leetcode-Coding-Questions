class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        
        int dec = 1, maxLen = 1, inc = 1, j = 1;

        while(j < nums.length) {
            if(nums[j] > nums[j - 1]) {
                inc++;
                dec = 1;
            } else if(nums[j] < nums[j - 1]) {
                dec++;
                inc = 1;
            } else {
                dec = 1;
                inc = 1;
            }

            maxLen = Math.max(maxLen, Math.max(inc, dec));

            j++;
        }

        

        return maxLen;
    }
}