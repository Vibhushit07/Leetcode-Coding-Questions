class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] res = new int[2];
        int num[] = new int[(n * n) + 1];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int t = grid[i][j];
                if(num[t] != 0) {
                    res[0] = t;
                }

                num[t]++;
            }
        }

        for(int i = 1; i < num.length; i++) {
            if(num[i] == 0) {
                res[1] = i;
            }
        }

        return res;
    }
}