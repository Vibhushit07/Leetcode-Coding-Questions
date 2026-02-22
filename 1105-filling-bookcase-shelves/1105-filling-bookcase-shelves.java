class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            int currH = 0;
            int currW = 0;

            for(int j = i - 1; j >= 0; j--) {
                int h = books[j][1];
                int w = books[j][0];

                if(currW + w > shelfWidth) {
                    break;
                }

                currW += w;
                currH = Math.max(currH, h);

                int shelfH = dp[j] + currH;
                dp[i] = Math.min(dp[i], shelfH);
            }
        }

        return dp[n];
    }
}