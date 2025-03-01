class Solution {
    public int[] applyOperations(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        int i = -1, j = 0;

        while(j < nums.length) {
            if(nums[j] != 0) {
                i++;
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }

            j++;
        }

        return nums;
    }
}