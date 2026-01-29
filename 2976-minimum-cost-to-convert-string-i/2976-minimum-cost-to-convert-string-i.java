class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] dist = new long[26][26];
        long INF = Long.MAX_VALUE;

        int len = original.length;
        int m = source.length();
        long minCost = 0L;

        for(long[] gr : dist) {
            Arrays.fill(gr, INF);
        }

        for(int i = 0; i < 26; i++) {
            dist[i][i] = 0L;
        }

        for(int i = 0; i < len; i++) {
            char src = original[i];
            char dest = changed[i];

            dist[src - 'a'][dest - 'a'] = Math.min(dist[src - 'a'][dest - 'a'], cost[i]);
        }

        floydWarshall(dist, INF);

        for(int i = 0; i < m; i++) {
            char src = source.charAt(i);
            char dest = target.charAt(i);

            if(dist[src - 'a'][dest - 'a'] == INF) {
                return -1;
            }

            minCost += (long)dist[src - 'a'][dest - 'a'];
        }

        return minCost;
    }

    private void floydWarshall(long[][] dist, long INF) {
        int V = 26;

        for(int k = 0; k < V; k++) {
            for(int i = 0; i < V; i++) {
                for(int j = 0; j < V; j++) {
                    if(dist[i][k] != INF && dist[k][j] != INF)
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }
}