class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0 || nums.length == 1)
            return nums.length;
        
        int count = 0;
        
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] != nums[i + 1]) {
                nums[count++] = nums[i];
            }
        }
        
        nums[count++] = nums[nums.length - 1];
        
        return count;
    }
}