public class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length, maxLength = 0;
        int[][] dp = new int[n][n];

        for (int[] row : dp) {
            Arrays.fill(row, 2);
        }

        for (int curr = 2; curr < n; curr++) {
            int left = 0, right = curr - 1;
            while (left < right) {
                int sum = arr[left] + arr[right];
                if (sum > arr[curr]) {
                    right--;
                } else if (sum < arr[curr]) {
                    left++;
                } else {
                    dp[right][curr] = dp[left][right] + 1;
                    maxLength = Math.max(maxLength, dp[right][curr]);
                    left++;
                    right--;
                }
            }
        }
        return maxLength > 2 ? maxLength : 0;
    }
}