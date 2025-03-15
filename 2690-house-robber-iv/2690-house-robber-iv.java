class Solution {

    private boolean robbed(int[] nums, int k, int mid) {
        int count = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] <= mid) {
                count++;
                i++;
            }
        }

        return count >= k;
    }

    public int minCapability(int[] nums, int k) {
        int left = 1;
        int right = Arrays.stream(nums).max().getAsInt();
        int ans = right;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(robbed(nums, k, mid)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}