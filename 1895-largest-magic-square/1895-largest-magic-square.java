class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int square = Math.min(m, n);
        int maxSquareLength = 1;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                maxSquareLength = Math.max(maxSquareLength, getMaxSquare(grid, i, j, square, m, n, maxSquareLength));
            }
        }

        return maxSquareLength;
    }

    private int getMaxSquare(int[][] grid, int i, int j, int square, int m, int n, int maxSquareLength) {

        int maxK = Math.min(m - i, n - j);

        for(int k = maxK; k > maxSquareLength; k--) {

            int target = 0;
            for (int c = j; c < j + k; c++) {
                target += grid[i][c];
            }

            if(isMagic(grid, i, j, k)) {
                return k;
            }
        }

        return 1;
    }

    private boolean isMagic(int[][] grid, int i, int j, int k) {
        int target = 0;
        for (int c = j; c < j + k; c++) {
            target += grid[i][c];
        }

        for (int r = i + 1; r < i + k; r++) { 
            int currentRowSum = 0;
            for (int c = j; c < j + k; c++) {
                currentRowSum += grid[r][c];
            }
            if (currentRowSum != target) return false; 
        }

        for (int c = j; c < j + k; c++) { 
            int currentColSum = 0;
            for (int r = i; r < i + k; r++) {
                currentColSum += grid[r][c];
            }
            if (currentColSum != target) return false; 
        }

        int pSum = 0, sSum = 0;
        for (int offSet = 0; offSet < k; offSet++) { 
            pSum += grid[i + offSet][j + offSet];
            sSum += grid[i + offSet][j + k - 1 - offSet];
        }

        if (pSum != sSum) return false;

        return pSum == target;
    }
}