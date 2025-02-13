class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        for(int num : nums) {
            pq.add((long) num);
        }

        int minOp = 0;

        while(!pq.isEmpty() && pq.peek() < k) {
            long x = pq.poll();

            if(pq.isEmpty()) {
                break;
            } else {
                long y = pq.poll();
                pq.add(2 * x + y);
                minOp++;
            }
        }
        return minOp;
    }
}