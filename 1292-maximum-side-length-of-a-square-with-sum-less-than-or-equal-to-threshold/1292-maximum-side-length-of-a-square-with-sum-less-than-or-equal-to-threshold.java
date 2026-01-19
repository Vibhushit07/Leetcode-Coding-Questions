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

        int lo = 1, hi = Math.min(m, n);

        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if(checkSum(prefixSum, m, n, mid, threshold)) {
                maxSide = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }        

        return maxSide;
    }

    private boolean checkSum(int[][] prefixSum, int m, int n, int side, int threshold) {
        if(side == 0) return true;

        for(int i = 0; i + side - 1 < m; i++) {
            for(int j = 0; j + side - 1 < n; j++) {
                int r = i + side - 1;
                int c = j + side - 1;

                int sum = prefixSum[r][c];

                if(i > 0) sum -= prefixSum[i - 1][c];
                if(j > 0) sum -= prefixSum[r][j - 1];
                if(i > 0 && j > 0) sum += prefixSum[i - 1][j - 1];

                if(sum <= threshold) return true;
            }
        }

        return false;
    }

}