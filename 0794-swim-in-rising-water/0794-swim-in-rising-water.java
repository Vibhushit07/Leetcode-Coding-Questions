class Solution {

    boolean isReachable(int i, int j, int n, int[][] grid, boolean isVisited[][], int x[], int y[], int mid) {
        if(i < 0 || j < 0 || i >= n || j >= n || isVisited[i][j] || grid[i][j] > mid) {
            return false;
        }

        isVisited[i][j] = true;

        if(i == n - 1 && j == n - 1) {
            return true;
        }

        for(int k = 0; k < 4; k++) {
            int ix = i + x[k];
            int jy = j + y[k];

            if(isReachable(ix , jy, n, grid, isVisited, x, y, mid)) {
                return true;
            }
        }

        return false;
    }

    public int swimInWater(int[][] grid) {
        int n = grid.length;

        int x[] = {0, 0, -1, 1};
        int y[] = {-1, 1, 0, 0};

        int minTime = 0, l = 0, r = n * n - 1;

        while(l <= r) {
            int mid = l + (r - l) / 2;
            boolean isVisited[][] = new boolean[n][n];

            if(isReachable(0 , 0, n, grid, isVisited, x, y, mid)) {
                minTime = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return minTime;
    }
}