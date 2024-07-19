class Solution {
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void rotate(int[] nums, int k) {
        
        int n = nums.length;
    
        if(n == 0 || n == 1)
            return;
        
        if(k >= n) {
            k %= n;
        }
        
        if(k == 0)
            return;
        
        for(int i = 0, j = n - k - 1; i < j; i++, j--) {
            swap(nums, i, j);
        }
        
        for(int i = n - k, j = n - 1; i < j; i++, j--) {
            swap(nums, i, j);
        }
        
        for(int i = 0, j = n - 1; i < j; i++, j--){
            swap(nums, i, j);
        }
    }
}