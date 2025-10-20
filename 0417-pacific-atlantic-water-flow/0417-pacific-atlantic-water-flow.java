class Solution {

    private void dfs(int[][] heights, int i, int j, int m, int n, int[] x, int[] y, 
        boolean visited[][], boolean isReachable[]) {
        
        visited[i][j] = true;
        if(i == 0 || j == 0) {
            isReachable[0] = true;
        }

        if(i == m - 1 || j == n - 1) {
            isReachable[1] = true;
        }

        if(isReachable[0] && isReachable[1]) {
            return;
        }

        for(int k = 0; k < 4; k++) {
            int i_ = i + x[k];
            int j_ = j + y[k];

            if(i_ >= 0 && i_ < m && j_ >= 0 && j_ < n && !visited[i_][j_]) {
                if(heights[i][j] >= heights[i_][j_]) {
                    dfs(heights, i_, j_, m, n, x, y, visited, isReachable);

                    if(isReachable[0] && isReachable[1]) {
                        return;
                    }
                }
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[] x = {0, 0, -1, 1};
        int[] y = {-1, 1, 0, 0};

        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                boolean visited[][] = new boolean[m][n];
                boolean isReachable[] = new boolean[2];

                dfs(heights, i, j, m, n, x, y, visited, isReachable);

                if(isReachable[0] && isReachable[1]) {
                    List<Integer> ind = new ArrayList<>();
                    ind.add(i);
                    ind.add(j);
                    res.add(ind);
                }
            }
        }

        return res;
    }
}