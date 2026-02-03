class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        int i = 1;
        boolean isInc1 = false, isDec = false, isInc2 = false;

        while(i < n && nums[i] > nums[i - 1]) {
            i++;
            isInc1 = true;
        }

        while(i < n && nums[i] < nums[i - 1]) {
            i++;
            isDec = true;
        }

        while(i < n && nums[i] > nums[i - 1]) {
            i++;
            isInc2 = true;
        }

        return i == n && isInc1 && isDec && isInc2;
    }
}