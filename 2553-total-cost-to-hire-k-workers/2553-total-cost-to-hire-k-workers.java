class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>();

        int l = 0, r = costs.length - 1;
        long cost = 0l;

        for (int i = 0; i < k; i++) {
            
            while(left.size() < candidates && l <= r) {
                left.add(costs[l++]);
            }

            while(right.size() < candidates && l <= r) {
                right.add(costs[r--]);
            }

            int le = left.size() > 0 ? left.peek() : Integer.MAX_VALUE;
            int ri = right.size() > 0 ? right.peek() : Integer.MAX_VALUE;

            if (le <= ri) {
                left.poll();
                cost += (long)le;
            } else {
                right.poll();
                cost += (long)ri;
            }
        }

        return cost;
    }
}