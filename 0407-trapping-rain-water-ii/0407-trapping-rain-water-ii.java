class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length, n = heightMap[0].length;
        int water = 0;

        PriorityQueue<int[]> boundary = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        boolean[][] visited = new boolean[m][n];

        int x[] = {-1, 1, 0, 0};
        int y[] = {0, 0, -1, 1};

        for(int i = 0; i < m; i++) {
            boundary.add(new int[]{i, 0, heightMap[i][0]});
            visited[i][0] = true;

            boundary.add(new int[]{i, n - 1, heightMap[i][n - 1]});
            visited[i][n - 1] = true;
        }

        for(int i = 0; i < n; i++) {
            boundary.add(new int[]{0, i, heightMap[0][i]});
            visited[0][i] = true;

            boundary.add(new int[]{m - 1, i, heightMap[m - 1][i]});
            visited[m - 1][i] = true;
        }

        while(!boundary.isEmpty()) {
            int[] cell = boundary.poll();
            int i = cell[0], j = cell[1], height = cell[2];

            for(int k = 0; k < 4; k++) {
                int i_ = i + x[k];
                int j_ = j + y[k];

                if(i_ >= 0 && i_ < m && j_ >= 0 && j_ < n && !visited[i_][j_]) {
                    water += Math.max(height - heightMap[i_][j_], 0);
                    visited[i_][j_] = true;

                    boundary.add(new int[]{i_, j_, 
                        Math.max(height, heightMap[i_][j_])});
                }
            }
        }

        return water;
    }
}