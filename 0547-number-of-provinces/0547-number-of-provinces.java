class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean visited[] = new boolean[isConnected.length];
        int count = 0;

        for(int i = 0; i < isConnected.length; i++) {
            if(!visited[i]) {
                DFS(visited, i, isConnected);
                count++;
            }
        }

        return count;
    }

    private void DFS(boolean[] visited, int source, int[][] graph) {
        visited[source] = true;

        for(int i = 0; i < graph.length; i++) {
            if(graph[source][i] == 1 && !visited[i]) {
                DFS(visited, i, graph);
            }
        }
    }
}