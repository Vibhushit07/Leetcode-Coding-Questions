class Solution {
    public long maxSumTrionic(int[] nums) {

        long[][] memo = new long[4][nums.length];

        for(long[] mem : memo) {
            Arrays.fill(mem, Long.MIN_VALUE);
        }

        return trionic(memo, nums, nums.length, 0, 0);
    }

    long trionic(long[][] memo, int[] nums, int n, int i, int trend) {

        if(i >= n) return trend == 3 ? 0 : Long.MIN_VALUE / 2;

        if(memo[trend][i] != Long.MIN_VALUE) return memo[trend][i];

        long skip = Long.MIN_VALUE / 2, take = Long.MIN_VALUE / 2;

        if(trend == 0) {
            skip = trionic(memo, nums, n, i + 1, 0);
        }

        if(trend == 3) {
            take = nums[i];
        }

        if(i + 1 < n) {
            int curr = nums[i];
            int next = nums[i + 1];

            if(trend == 0 && curr < next) {
                take = Math.max(take, curr + trionic(memo, nums, n, i + 1, 1));
            }

            if(trend == 1 && curr < next) {
                take = Math.max(take, curr + trionic(memo, nums, n, i + 1, 1));
            }

            if(trend == 1 && curr > next) {
                take = Math.max(take, curr + trionic(memo, nums, n, i + 1, 2));
            }

            if(trend == 2 && curr > next) {
                take = Math.max(take, curr + trionic(memo, nums, n, i + 1, 2));
            }

            if(trend == 2 && curr < next) {
                take = Math.max(take, curr + trionic(memo, nums, n, i + 1, 3));
            }

            if(trend == 3 && curr < next) {
                take = Math.max(take, curr + trionic(memo, nums, n, i + 1, 3));
            }
        }

        memo[trend][i] = Math.max(skip, take);
        return memo[trend][i];
    }
}