class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long sum = 0, count = 0, min = (long)Integer.MAX_VALUE;

        for(int n : nums) {
            if((n ^ k) > n) {
                sum += (n ^ k);
                count++;
                min = Math.min(min, (long)(n ^ k) - n);
            } else {
                sum += n;
                min = Math.min(min, (long)n - (n ^ k));
            }
        }

        return count % 2 == 0 ? sum : sum - min;
    }
}