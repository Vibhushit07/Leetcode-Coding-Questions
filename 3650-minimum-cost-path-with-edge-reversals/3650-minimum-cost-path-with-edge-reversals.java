class Solution {
    class Node {
        int src;
        int dist;

        Node(int src, int dist) {
            this.src = src;
            this.dist = dist;
        }
    }

    public int minCost(int n, int[][] edges) {
        List<List<Node>> adjList = new ArrayList<>();

        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int d = edges[i][2];

            adjList.get(u).add(new Node(v, d));
            adjList.get(v).add(new Node(u, 2 * d));
        }

        dijkstra(adjList, dist);

        return dist[n - 1] != Integer.MAX_VALUE ? dist[n - 1] : -1;
    }

    private void dijkstra(List<List<Node>> adjList, int[] dist) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);

        pq.add(new Node(0, 0));
        dist[0] = 0;

        while(!pq.isEmpty()) {
            Node node = pq.poll();

            int src = node.src;
            int d = node.dist;

            for(Node n : adjList.get(src)) {
                int dis = dist[src] + n.dist;

                if(dis < dist[n.src]) {
                    dist[n.src] = dis;
                    pq.add(new Node(n.src, dis));
                }
            }
        }
    }
}