class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int min = 0, max = 0, sum = 0, maxSum = 0;

        for(int n : nums) {
            sum += n;

            int mi = Math.abs(sum - min);
            int ma = Math.abs(sum - max);

            maxSum = Math.max(maxSum, Math.max(mi, ma)); 
            min = Math.min(min, sum);
            max = Math.max(max, sum);
        }

        return maxSum;
    }
}