class Solution {
    private static final int mod = 1_000_000_007;
    public int numTilings(int n) {
        
        int dp[] = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;

        if(n >= 2) {
            dp[2] = 2;
        }

        if(n >= 3) {
            dp[3] = 5;
        }

        for(int i = 4; i <= n; i++) {
            dp[i] = (int)((2L * dp[i - 1] + dp[i - 3]) % mod);
        }

        return dp[n];
    }
}