class Solution {

    int MIN_VAL = -10000000;
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int memo[][] = new int[nums1.length][nums2.length];

        for(int[] row : memo) {
            Arrays.fill(row, MIN_VAL);
        }

        return solve(nums1, nums2, 0, 0, memo);
    }

    private int solve(int[] nums1, int[] nums2, int i, int j, int[][] memo) {

        if(i >= nums1.length || j >= nums2.length) {
            return MIN_VAL;
        }

        if(memo[i][j] != MIN_VAL) {
            return memo[i][j];
        }

        int currProd = nums1[i] * nums2[j];
        int takeBoth = currProd + Math.max(0, solve(nums1, nums2, i + 1, j + 1, memo));

        int skip1 = solve(nums1, nums2, i + 1, j, memo);
        int skip2 = solve(nums1, nums2, i, j + 1, memo);

        return memo[i][j] = Math.max(takeBoth, Math.max(skip1, skip2));
    }
}