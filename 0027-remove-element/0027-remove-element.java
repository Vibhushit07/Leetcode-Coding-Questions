class Solution {
    public int removeElement(int[] nums, int val) {
        
        int n = nums.length, j = 0;
        int num[] = new int[n];
        
        for(int i = 0; i < n; i++) {
            if(nums[i] != val) {
                num[j++] = nums[i];
            }
        }
        
        for(int i = 0; i < j; i++) {
            nums[i] = num[i];
        }
        
        return j;
    }
}