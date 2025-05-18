class Solution {
    private final int MOD = 1_000_000_007;
    public int numOfWays(int n) {
        char color[] = new char[]{'R', 'G', 'B'};
        int result = 0;

        List<String> colorComb = new ArrayList<>();
        getComb(colorComb, color, 3, "", '0');
        int dp[][] = new int[n][colorComb.size()];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        for(int i = 0; i < colorComb.size(); i++) {
            result = (result + solve(dp, colorComb, n - 1, 3, i)) % MOD;
        }

        return result;
    }

    private void getComb(List<String> colorComb, char color[], int rows, String comb, char prevColor) {
        if(rows == 0) {
            colorComb.add(comb);
        } else {
            for(char c : color) {
                if(c != prevColor) {
                    getComb(colorComb, color, rows - 1, comb + c, c);
                }
            }
        }
    }

    private int solve(int dp[][], List<String> colorComb, int cols, int m, int prevCol) {
        if(cols == 0) {
            return 1;
        }

        if(dp[cols][prevCol] != -1) return dp[cols][prevCol];
        
        String comb = colorComb.get(prevCol);
        int ways = 0;

        for(int i = 0; i < colorComb.size(); i++) {
            boolean valid = true;
            String curr = colorComb.get(i);
            for(int j = 0; j < m; j++) {
                if(comb.charAt(j) == curr.charAt(j)) {
                    valid = false;
                    break;
                }
            }

            if(valid) {
                ways = (ways + solve(dp, colorComb, cols - 1, m, i)) % MOD;
            } 
        }

        dp[cols][prevCol] = ways;

        return ways;
    }
}