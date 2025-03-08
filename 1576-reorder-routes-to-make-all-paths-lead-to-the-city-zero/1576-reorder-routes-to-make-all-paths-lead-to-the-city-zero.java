class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> adjList = new ArrayList<>();
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int[] e : connections) {
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(-e[0]);
        }

        return DFS(adjList, visited, 0);
    }

    private int DFS(List<List<Integer>> adjList, boolean[] visited, int source) {
        visited[source] = true;

        int count = 0;

        for(int city : adjList.get(source)) {
            if(!visited[Math.abs(city)]) {
                count += DFS(adjList, visited, Math.abs(city)) + ((city > 0) ? 1 : 0);
            }
        }

        return count;
    }
}