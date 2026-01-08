class Solution {

    int MIN_VAL = -10000000;
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;

        if (n < m) {
            return solve(nums1, nums2);
        } else {
            return solve(nums2, nums1);
        }
        
    }

    private int solve(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;

        int dp[] = new int[m];

        dp[0] = nums1[0] * nums2[0];

        for(int j = 1; j < m; j++) {
            dp[j] = Math.max(dp[j - 1], nums1[0] * nums2[j]);
        }

        for(int i = 1; i < n; i++) {
            int prev = dp[0];

            dp[0] = Math.max(dp[0], nums1[i] * nums2[0]);

            for(int j = 1; j < m; j++) {
                int temp = dp[j];

                int currProd = nums1[i] * nums2[j];
                int takeBoth = currProd + Math.max(0, prev);

                dp[j] = Math.max(takeBoth, Math.max(dp[j], dp[j - 1]));

                prev = temp;
            }
        }

        return dp[m - 1];
    }
}