import java.util.*;

class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] queries) {
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj[u].add(new int[]{v, w});
            adj[v].add(new int[]{u, w});
        }

        int[] component = new int[n];
        Arrays.fill(component, -1);
        List<Integer> compValue = new ArrayList<>();
        int compId = 0;

        for (int i = 0; i < n; i++) {
            if (component[i] == -1) {
                int[] compAnd = new int[]{(1 << 30) - 1}; 
                dfs(i, compId, compAnd, component, adj);
                compValue.add(compAnd[0]);
                compId++;
            }
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int s = queries[i][0], t = queries[i][1];
            if (component[s] != component[t]) {
                res[i] = -1;
            } else {
                res[i] = compValue.get(component[s]);
            }
        }
        return res;
    }

    private void dfs(int node, int compId, int[] compAnd, int[] component, List<int[]>[] adj) {
        component[node] = compId;
        for (int[] neighbor : adj[node]) {
            int next = neighbor[0], weight = neighbor[1];
            compAnd[0] &= weight;
            if (component[next] == -1) {
                dfs(next, compId, compAnd, component, adj);
            }
        }
    }
}