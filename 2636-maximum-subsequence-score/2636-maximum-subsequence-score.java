class Solution {

    class Node {
        int val, ind;

        Node(int v, int i) {
            this.val = v;
            this.ind = i;
        }
    }

    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        long sum = 0, max = Long.MIN_VALUE;
        int [][]nums = new int[n][2];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < n; i++) {
            nums[i][0] = nums1[i];
            nums[i][1] = nums2[i];
        }

        Arrays.sort(nums, (a, b) -> Integer.compare(b[1], a[1]));

        for(int i = 0; i < n; i++) {
            System.out.println(nums[i][0] + " " + nums[i][1]);
        }

        for(int[] n1 : nums) {
            sum += n1[0];
            pq.add(n1[0]);

            while(pq.size() > k) {
                sum -= pq.poll();
            }

            if(pq.size() == k) {
                max = Math.max(max, sum * n1[1]);
            }
        }


        return max;
    }
}