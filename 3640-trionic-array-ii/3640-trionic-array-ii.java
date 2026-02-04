class Solution {
    public long maxSumTrionic(int[] nums) {
        int n = nums.length;

        long[][] dp = new long[4][n + 1];

        for(int trend = 0; trend < 4; trend++) {
            dp[trend][n] = (trend == 3) ? 0L : Long.MIN_VALUE;
        }

        for(int i = n - 1; i >= 0; i--) {
            for(int trend = 0; trend < 4; trend++) {
                long skip = Long.MIN_VALUE / 2, take = Long.MIN_VALUE / 2;

                if(trend == 0) {
                    skip = dp[0][i + 1];
                }

                if(trend == 3) {
                    take = nums[i];
                }

                if(i + 1 < n) {
                    int curr = nums[i];
                    int next = nums[i + 1];

                    if(trend == 0 && curr < next) {
                        take = Math.max(take, curr + dp[1][i + 1]);
                    }

                    if(trend == 1 && curr < next) {
                        take = Math.max(take, curr + dp[1][i + 1]);
                    }

                    if(trend == 1 && curr > next) {
                        take = Math.max(take, curr + dp[2][i + 1]);
                    }

                    if(trend == 2 && curr > next) {
                        take = Math.max(take, curr + dp[2][i + 1]);
                    }

                    if(trend == 2 && curr < next) {
                        take = Math.max(take, curr + dp[3][i + 1]);
                    }

                    if(trend == 3 && curr < next) {
                        take = Math.max(take, curr + dp[3][i + 1]);
                    }

                }

                dp[trend][i] = Math.max(skip, take);
            }
        }

        return dp[0][0];
    }
}