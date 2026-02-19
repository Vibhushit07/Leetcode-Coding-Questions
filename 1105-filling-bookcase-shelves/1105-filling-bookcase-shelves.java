class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[][] memo = new int[n][shelfWidth + 1];

        for(int[] m : memo) {
            Arrays.fill(m, -1);
        }

        return solve(memo, books, shelfWidth, 0, 0, shelfWidth);    
    }

    private int solve(int[][] memo, int[][] books, int shelfWidth, int i, int shelfHeight, int remWidth) {
        if(i >= books.length) return shelfHeight;

        if(memo[i][remWidth] != -1) return memo[i][remWidth];

        int bookW = books[i][0];
        int bookH = books[i][1];

        int keep = Integer.MAX_VALUE;
        if(bookW <= remWidth) {
            keep = solve(memo, books, shelfWidth, i + 1, Math.max(shelfHeight, bookH), 
                remWidth - bookW);
        }

        int skip = shelfHeight + solve(memo, books, shelfWidth, i + 1, bookH, shelfWidth - bookW);

        return memo[i][remWidth] = Math.min(keep, skip);
    }
}