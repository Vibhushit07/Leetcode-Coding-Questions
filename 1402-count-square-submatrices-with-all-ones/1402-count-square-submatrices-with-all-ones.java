class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, squares = 0;

        int dp[][] = new int[m][n];
        dp[0][0] = matrix[0][0];
        squares += dp[0][0];

        for(int i = 1; i < m; i++) {
            dp[i][0] = matrix[i][0];
            squares += dp[i][0];
        }

        for(int i = 1; i < n; i++) {
            dp[0][i] = matrix[0][i];
            squares += dp[0][i];
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == 1) {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1],
                        Math.min(dp[i - 1][j], dp[i][j - 1])
                    );
                    squares += dp[i][j];
                }
            }
        }

        return squares;
    }
}