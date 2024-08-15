class Solution {
    
    void swap(int nums[], int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, hi = nums.length - 1;
        
        while(mid <= hi) {
            if(nums[mid] == 0) {
                swap(nums, mid, low);
                low++;
                mid++;
            } else if(nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, hi);
                hi--;
            }
        }
    }
}