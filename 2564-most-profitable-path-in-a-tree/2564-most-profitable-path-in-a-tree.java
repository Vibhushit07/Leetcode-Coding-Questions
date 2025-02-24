class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int nodes = amount.length;

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < nodes; i++) {
            adj.add(new ArrayList<>());
        } 

        for(int i = 0; i < nodes - 1; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        boolean visited[] = new boolean[nodes];
        List<Integer> bobPath = new ArrayList<>();
        List<Integer> currPath = new ArrayList<>();
        findBobPath(adj, currPath, visited, bob, bobPath);

        for(int i = 0; i < currPath.size(); i++) {
            System.out.print(currPath.get(i) + " ");
        }

        System.out.println();

        for(int i = 0; i <= currPath.size() / 2; i++) {
            if(currPath.size() % 2 == 0 && i == currPath.size() / 2) {
                amount[currPath.get(i)] /= 2;
            } else {
                amount[currPath.get(i)] = 0;
            }
        }

        for(int i = 0; i < nodes; i++) {
            System.out.print(amount[i] + " ");
        }

        Arrays.fill(visited, false);

        return maximumAmount(adj, amount, visited, 0);
    }

    private Boolean findBobPath(List<List<Integer>> adj, List<Integer> currPath, boolean visited[],
                                int bob, List<Integer> bobPath) {

        if(bob == 0) {
            bobPath.addAll(currPath);
            return true;
        }

        currPath.add(bob);
        visited[bob] = true;

        for(int nbr : adj.get(bob)) {
            if(!visited[nbr] && findBobPath(adj, currPath, visited, nbr, bobPath)) {
                return true;
            }
        }

        currPath.remove(currPath.size() - 1);
        return false;
    }

    private int maximumAmount(List<List<Integer>> adj, int[] amount, boolean visited[], int node) {
        visited[node] = true;
        int maxAmount = Integer.MIN_VALUE;

        for(int nbr : adj.get(node)) {
            if(!visited[nbr]) {
                int income = maximumAmount(adj, amount, visited, nbr);
                maxAmount = Math.max(maxAmount, income + amount[node]);
            }
        }

        return maxAmount == Integer.MIN_VALUE ? amount[node] : maxAmount;
    }
}