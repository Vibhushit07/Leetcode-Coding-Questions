class Solution {
    public boolean check(int[] nums) {
        
        int increasing = 0;
        
        if(nums.length < 2) {
            return true;
        }
        
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] > nums[i + 1])
                increasing++;
        }
        
        if(increasing == 0 || (increasing == 1 && nums[0] >= nums[nums.length - 1]))
            return true;
        
        return false;
    }
}