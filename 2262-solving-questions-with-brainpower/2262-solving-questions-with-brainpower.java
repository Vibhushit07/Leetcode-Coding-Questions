class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long dp[] = new long[n];

        dp[n - 1] = questions[n - 1][0];

        for (int i = n - 2; i >= 0; i--) {
            int brain = (i + questions[i][1] + 1 < n) ? i + questions[i][1] + 1 : -1;     
            if (brain == -1) {
                dp[i] = Math.max((long) questions[i][0], (long) dp[i + 1]);
            } else {
                dp[i] = Math.max((long) questions[i][0] + dp[brain], (long) dp[i + 1]);
            }
        }

        return dp[0];
    }
}