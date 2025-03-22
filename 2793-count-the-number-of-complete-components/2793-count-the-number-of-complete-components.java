class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        boolean visited[] = new boolean[n];
        int components = 0;

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int comp[] = new int[2];
                dfs(adj, visited, i, comp);
                if(comp[0] * (comp[0] - 1) == comp[1])
                    components++;
            }
        }

        return components;
    }

    private void dfs(List<List<Integer>> adj, boolean visited[], int v, int comp[]) {
        visited[v] = true;
        comp[0]++;
        comp[1] += adj.get(v).size();
        for (int u : adj.get(v)) {
            if (!visited[u]) {
                dfs(adj, visited, u, comp);
            }
        }
    }
}