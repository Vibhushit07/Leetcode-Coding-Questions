class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length, n = points[0].length;
        long[][] dp = new long[m][n];

        for(int i = 0; i < n; i++) {
            dp[0][i] = points[0][i];
        }

        for(int i = 1; i < m; i++) {
            long[] left = new long[n];
            long[] right = new long[n];

            left[0] = dp[i - 1][0];
            for(int j = 1; j < n; j++) {
                left[j] = Math.max(dp[i - 1][j], left[j - 1] - 1);
            }

            right[n - 1] = dp[i - 1][n - 1];
            for(int j = n - 2; j >= 0; j--) {
                right[j] = Math.max(dp[i - 1][j], right[j + 1] - 1);
            }

            for(int j = 0; j < n; j++) {
                dp[i][j] = points[i][j] + Math.max(right[j], left[j]);
            }
        }

        long res = Long.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            res = Math.max(dp[m - 1][i], res);
        }

        return res;
    }
}