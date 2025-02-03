class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        
        int len = 1, maxLen = 1, i = 0, j = 1;

        while(j < nums.length) {
            if(nums[j] > nums[j - 1]) {
                len++;
                maxLen = Math.max(len, maxLen);
            } else {
                len = 1;
            }
            j++;
        }

        j = 1;
        len = 1;

        while(j < nums.length) {
            if(nums[j] < nums[j - 1]) {
                len++;
                maxLen = Math.max(len, maxLen);
            } else {
                len = 1;
            }
            j++;
        }

        return maxLen;
    }
}