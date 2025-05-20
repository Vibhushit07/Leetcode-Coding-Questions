class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int res[] = new int[n];

        for(int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            res[l] += 1;

            if(r + 1 < n) {
                res[r + 1] -= 1;
            } 
        }

        for(int i = 0; i < n; i++) {
            if(i > 0) {
                res[i] += res[i - 1];
            }

            if(res[i] < nums[i]) {
                return false;
            }
        }

        return true;
    }
}