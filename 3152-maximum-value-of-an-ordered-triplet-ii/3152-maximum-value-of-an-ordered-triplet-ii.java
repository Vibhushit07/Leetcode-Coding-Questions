class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int pre[] = new int[n];
        int suf[] = new int[n];
        long max = 0l;

        pre[0] = nums[0];
        suf[n - 1] = nums[n - 1];

        for (int i = 1; i < n; i++) {
            pre[i] = Math.max(pre[i - 1], nums[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            suf[i] = Math.max(suf[i + 1], nums[i]);
        }

        for (int i = 1; i < n - 1; i++) {
            long triplet = ((long) pre[i - 1] - nums[i]) * (long) suf[i + 1];
            max = Math.max(max, triplet);
        }

        return max;
    }
}