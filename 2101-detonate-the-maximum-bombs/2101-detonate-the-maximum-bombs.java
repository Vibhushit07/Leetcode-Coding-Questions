class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++) {
            int x1 = bombs[i][0];
            int y1 = bombs[i][1];
            int r1 = bombs[i][2];

            long radius = (long)r1 * r1;

            for(int j = 0; j < n; j++) {
                if(i != j) {
                    int x2 = bombs[j][0];
                    int y2 = bombs[j][1];
                    int r2 = bombs[j][2];

                    long x = x2 - x1;
                    long y = y2 - y1;
                    long dist = x * x + y * y;

                    if(radius >= dist) {
                        adjList.get(i).add(j);
                    }
                }
            }
        }

        int maxBombs = 0;

        for(int i = 0; i < n; i++) {
            Set<Integer> visited = new HashSet<>();
            DFS(adjList, i, visited);
            maxBombs = Math.max(maxBombs, visited.size());
        }

        return maxBombs;
    }

    private void DFS(List<List<Integer>> adjList, int v, Set<Integer> visited) {

        visited.add(v);

        for(int u : adjList.get(v)) {
            if(!visited.contains(u)) {
                DFS(adjList, u, visited);
            }
        }

    }
}