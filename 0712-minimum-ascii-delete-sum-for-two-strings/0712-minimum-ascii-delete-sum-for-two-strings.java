class Solution {
    public int minimumDeleteSum(String s1, String s2) {

        int n = s1.length(), m = s2.length();
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        dp[0][0] = 0;

        for(int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
        }

        for(int j = 1; j <= m; j++) {
            dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1);
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int delete1 = dp[i - 1][j] + s1.charAt(i - 1);
                    int delete2 = dp[i][j - 1] + s2.charAt(j - 1);

                    dp[i][j] = Math.min(delete1, delete2);
                }
            }
        }

        return dp[n][m];
    }
}