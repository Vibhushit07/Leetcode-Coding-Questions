class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean visited[] = new boolean[rooms.size()];

        DFS(rooms, visited, 0);

        for(int i = 0; i < rooms.size(); i++) {
            if(!visited[i])
                return false;
        }

        return true;
    }

    private void DFS(List<List<Integer>> rooms, boolean[] visited, int source) {
        visited[source] = true;

        for(int v : rooms.get(source)) {
            if(!visited[v]){
                DFS(rooms, visited, v);
            }
        }
    }
}