class Solution {

    private int[][] longestCommonSupersequence(String str1, String str2) {
        int n1 = str1.length(), n2 = str2.length();

        int dp[][] = new int[n1 + 1][n2 + 1];

        for(int i = n1 - 1; i >= 0; i--) {
            for(int j = n2 - 1; j >= 0; j--) {
                if(str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        return dp;
    }

    public String shortestCommonSupersequence(String str1, String str2) {
        int n1 = str1.length(), n2 = str2.length(), i = 0, j = 0;

        String str = "";

        int dp[][] = longestCommonSupersequence(str1, str2);

        while(i < n1 && j < n2) {
            if(str1.charAt(i) == str2.charAt(j)) {
                str += str1.charAt(i);
                i++;
                j++;
            } else if(dp[i + 1][j] > dp[i][j + 1]) {
                str += str1.charAt(i);
                i++;
            } else {
                str += str2.charAt(j);
                j++;
                
            }
        }

        while(i < n1) {
            str += str1.charAt(i);
            i++;
        }

        while(j < n2) {
            str += str2.charAt(j);
            j++;
        }

        return str;

    }
}