class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length, n = grid[0].length, y = grid[0][0], total = 0, prefix = 0, k = 0;
        int nums[] = new int[m * n];
        int res = Integer.MAX_VALUE;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] % x != y % x) {
                    return -1;
                }

                total += grid[i][j];
                nums[k++] = grid[i][j];
            }
        }

        Arrays.sort(nums);

        for(int i = 0; i < k; i++) {
            int left = nums[i] * i - prefix;
            int right = total - prefix - (nums[i] * (k - i));
            prefix += nums[i];

            int op = (left + right) / x;

            res = Math.min(res, op);
        }

        return res;
    }
}