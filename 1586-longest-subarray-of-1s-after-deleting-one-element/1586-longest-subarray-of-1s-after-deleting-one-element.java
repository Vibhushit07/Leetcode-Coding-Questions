class Solution {
    public int longestSubarray(int[] nums) {
        int l = 0, len = 0, z = 0;

        for(int r = 0; r < nums.length; r++) {
            if(nums[r] == 0)
                z++;

            while(z > 1) {
                if(nums[l] == 0)
                    z--;
                l++;
            }

            len = Math.max(len, r - l);
        }

        return len == nums.length ? len - 1 : len;
    }
}