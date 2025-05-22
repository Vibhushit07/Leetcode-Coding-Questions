class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        int n = nums.length, selected = 0, j = 0, q = queries.length;
        PriorityQueue<Integer> candidate = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        PriorityQueue<Integer> choosen = new PriorityQueue<>();

        Arrays.sort(queries, (a, b) -> Integer.compare(a[0], b[0]));

        for(int i = 0; i < n; i++) {
            while(j < q && queries[j][0] == i) {
                candidate.add(queries[j++][1]);
            }

            nums[i] -= choosen.size();

            while(nums[i] > 0 && !candidate.isEmpty() && candidate.peek() >= i) {
                choosen.add(candidate.poll());
                nums[i]--;
                selected++;
            }

            if(nums[i] > 0) {
                return -1;
            }

            while(!choosen.isEmpty() && choosen.peek() <= i) {
                choosen.poll();
            }
        }

        return q - selected;
    }
}