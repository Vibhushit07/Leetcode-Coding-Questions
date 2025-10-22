class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int result = Integer.MIN_VALUE;
        int[] dp = new int[n];

        for(int i = n - 1; i >= 0; i--) {

            dp[i] = energy[i] + ((i + k) < n ? dp[i + k] : 0);
            result = Math.max(result, dp[i]);
        }

        return result;
    }
}