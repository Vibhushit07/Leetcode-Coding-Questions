class Solution {
    public long maximumTripletValue(int[] nums) {

        long max = (long) Integer.MIN_VALUE;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    long triplet = (nums[i] - nums[j]) * (long) nums[k];
                    max = Math.max(max, triplet);
                }
            }
        }
        return max >= 0l ? max : 0;

    }
}