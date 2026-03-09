class Solution {

    int M = 1_000_000_007;

    public int numberOfStableArrays(int zero, int one, int limit) {

        int[][][] dp = new int[zero + 1][one + 1][2];

        dp[0][0][0] = 1;
        dp[0][0][1] = 1;

        for(int zeroLeft = 0; zeroLeft <= zero; zeroLeft++) {
            for(int oneLeft = 0; oneLeft <= one; oneLeft++) {
                if(zeroLeft == 0 && oneLeft == 0) continue;

                int result = 0;

                for(int i = 1; i <= Math.min(zeroLeft, limit); i++) {
                    result = (result + dp[zeroLeft - i][oneLeft][0]) % M;
                }

                dp[zeroLeft][oneLeft][1] = result;
                
                result = 0;

                for(int i = 1; i <= Math.min(oneLeft, limit); i++) {
                    result = (result + dp[zeroLeft][oneLeft - i][1]) % M;
                }

                dp[zeroLeft][oneLeft][0] = result;
            }
        }

        return (dp[zero][one][0] + dp[zero][one][1]) % M;
    }
}