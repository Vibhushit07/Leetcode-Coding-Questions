class Solution {

    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length, n = maze[0].length;
        int dir[][] = new int[][] { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {entrance[0], entrance[1], 0});

        maze[entrance[0]][entrance[1]] = '+';

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1], d = curr[2];

            for(int i = 0; i < 4; i++) {
                int x = r + dir[i][0], y = c + dir[i][1];

                if(x == -1 || y == -1 || x == m || y == n || maze[x][y] == '+') {
                    continue;
                }

                if(x == 0 || y == 0 || x == m - 1 || y == n - 1) {
                    return d + 1;
                }

                maze[x][y] = '+';
                q.add(new int[] {x, y, d + 1});
            }
        }

        

        return -1;
    }
}