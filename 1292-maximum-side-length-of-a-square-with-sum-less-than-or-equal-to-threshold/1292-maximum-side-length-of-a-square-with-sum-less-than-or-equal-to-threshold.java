class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        
        int m = mat.length, n = mat[0].length;
        int maxSide = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int offset = Math.min(m - i, n - j);
                for(int k = 0; k < offset; k++) {
                    if(findSum(mat, i, j, i + k, j + k) <= threshold) {
                        maxSide = Math.max(maxSide, k + 1);
                    } else {
                        break;
                    }
                }
            }
        }

        return maxSide;
    }

    private int findSum(int[][] mat, int i, int j, int m, int n) {
        int sum = 0;

        for(int r = i; r <= m; r++) {
            for(int c = j; c <= n; c++) {
                sum += mat[r][c];
            }
        }

        return sum;
    }
}