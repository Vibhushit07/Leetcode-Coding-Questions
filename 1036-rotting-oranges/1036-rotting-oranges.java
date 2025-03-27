class Solution {

    class Node {
        int i, j;

        Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length, time = 0;

        int d[][] = {{0, -1 },{ 0, 1 },{ -1, 0 },{ 1, 0 } };

        Queue<Node> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Node(i, j));
                    
                }
            }
        }

        q.add(null);

        while (!q.isEmpty()) {
            Node node = q.poll();

            if(node == null) {
                if(!q.isEmpty()) {
                    q.add(null);
                    time++;
                }
            } else {

                System.out.println(node);

                for (int i = 0; i < 4; i++) {
                    int dx = node.i + d[i][0];
                    int dy = node.j + d[i][1];
                    if (isValid(dx, dy, m, n) && grid[dx][dy] == 1) {
                        q.add(new Node(dx, dy));
                        grid[dx][dy] = 2;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return time;
    }

    boolean isValid(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}