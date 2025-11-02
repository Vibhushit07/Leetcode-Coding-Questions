class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];

        for (int[] guard : guards) 
            grid[guard[0]][guard[1]] = 1;

        for (int[] wall : walls) 
            grid[wall[0]][wall[1]] = -1;

        for(int i = 0; i < guards.length; i++) {
            int j = guards[i][0];
            int k = guards[i][1];

            for(int x = j - 1; x >= 0; x--) {
                if(grid[x][k] == -1 || grid[x][k] == 1) {
                    break;
                }
                grid[x][k] = 2;
            }

            for(int x = j + 1; x < m; x++) {
                if(grid[x][k] == -1 || grid[x][k] == 1) {
                    break;
                }
                grid[x][k] = 2;
            }

             for(int x = k - 1; x >= 0; x--) {
                if(grid[j][x] == -1 || grid[j][x] == 1) {
                    break;
                }
                grid[j][x] = 2;
            }

            for(int x = k + 1; x < n; x++) {
                if(grid[j][x] == -1 || grid[j][x] == 1) {
                    break;
                }
                grid[j][x] = 2;
            }
        }

        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}