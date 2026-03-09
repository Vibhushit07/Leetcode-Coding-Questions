class Solution {

    int M = 1_000_000_007;

    public int numberOfStableArrays(int zero, int one, int limit) {

        int[][][] memo = new int[zero + 1][one + 1][2];

        for(int[][] z : memo) {
            for(int[] o : z) {
                Arrays.fill(o, -1);
            }
        }

        int startWithOne = solve(zero, one, 1, limit, memo);
        int startWithZero = solve(zero, one, 0, limit, memo);

        return (startWithOne + startWithZero) % M;
    }

    int solve(int zeroLeft, int oneLeft, int lastWasOne, int limit, int[][][] memo) {
        if(zeroLeft == 0 && oneLeft == 0) return 1;

        if(memo[zeroLeft][oneLeft][lastWasOne] != -1) return memo[zeroLeft][oneLeft][lastWasOne];

        int result = 0;

        if(lastWasOne == 1) {
            for(int i = 1; i <= Math.min(zeroLeft, limit); i++) {
                result = (result + solve(zeroLeft - i, oneLeft, 0, limit, memo)) % M;
            }
        } else {
            for(int i = 1; i <= Math.min(oneLeft, limit); i++) {
                result = (result + solve(zeroLeft, oneLeft - i, 1, limit, memo)) % M;
            }
        }

        return memo[zeroLeft][oneLeft][lastWasOne] = result;
    }
}