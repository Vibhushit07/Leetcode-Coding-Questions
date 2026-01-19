class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        
        int m = mat.length, n = mat[0].length;
        int maxSide = 0;

        int[][] prefixSum = new int[m][n];

        prefixSum[0][0] = mat[0][0];

        for(int j = 1; j < n; j++) {
            prefixSum[0][j] = mat[0][j] + prefixSum[0][j - 1];
        }

        for(int i = 1; i < m; i++) {
            prefixSum[i][0] = mat[i][0] + prefixSum[i - 1][0];
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                prefixSum[i][j] = prefixSum[i - 1][j] 
                    + prefixSum[i][j - 1]
                    - prefixSum[i - 1][j - 1]
                    + mat[i][j];
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int offset = Math.min(m - i, n - j);
                for(int k = 0; k < offset; k++) {
                    int r = i + k, c = j + k;
                    int sum = prefixSum[r][c];

                    if(i > 0) sum -= prefixSum[i - 1][c];
                    if(j > 0) sum -= prefixSum[r][j - 1];
                    if(i > 0 && j > 0) sum += prefixSum[i - 1][j - 1];

                    if(sum <= threshold) {
                        maxSide = Math.max(maxSide, k + 1);
                    } else {
                        break;
                    }
                }
            }
        }

        return maxSide;
    }

}