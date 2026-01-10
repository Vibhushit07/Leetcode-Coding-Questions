class Solution {
    public int minimumDeleteSum(String s1, String s2) {


        int[][] memo = new int[s1.length()][s2.length()];

        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return solve(s1, s2, 0, 0, memo);
    }

    private int solve(String s1, String s2, int i, int j, int[][] memo) {

        if(i < s1.length() && j >= s2.length()) {
            return deleteAll(s1, i);
        }

        if(i >= s1.length() && j < s2.length()) {
            return deleteAll(s2, j);
        }

        if(i >= s1.length() || j >= s2.length()) {
            return 0;
        }

        if(memo[i][j] != -1) {
            return memo[i][j];
        }

        if(s1.charAt(i) == s2.charAt(j)) {
            return memo[i][j] = solve(s1, s2, i + 1, j + 1, memo);
        }

        int skip1 = (int)s1.charAt(i) + solve(s1, s2, i + 1, j, memo);
        int skip2 = (int)s2.charAt(j) + solve(s1, s2, i, j + 1, memo);

        return memo[i][j] = Math.min(skip1, skip2);
    }

    private int deleteAll(String s, int i) {
        int delete = 0;

        for(int j = i; j < s.length(); j++) {
            delete += s.charAt(j);
        }

        return delete;
    }
}