class Solution {
    public int minOperations(int[] nums) {
        int min = 0, n = nums.length;

        for(int i = 0; i < n - 2; i++) {
            if(nums[i] == 0) {
                for(int j = i; j < i + 3; j++) {
                    nums[j] ^= 1;
                }
                min++;
            }
        }

        if(nums[n - 1] == 0 || nums[n - 2] == 0) 
            return -1;
        return min;
    }
}