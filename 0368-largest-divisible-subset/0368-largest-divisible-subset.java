class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {

        List<Integer> res = new ArrayList<>();

        int n = nums.length;
        int dp[] = new int[n];
        int hash[] = new int[n];
        Arrays.fill(dp, 1);
        Arrays.sort(nums);

        int maxLen = 1, lastInd = 0;

        for(int i = 1; i < n; i++) {
            hash[i] = i;
            for(int j = 0; j < i; j++) {
                if(nums[i] % nums[j] == 0 && dp[i] < 1 + dp[j]) {
                    dp[i] = 1 + dp[j];
                    hash[i] = j;
                }
            }

            if(dp[i] > maxLen) {
                maxLen = dp[i];
                lastInd = i;
            }
        }

        while(hash[lastInd] != lastInd) {
            res.add(nums[lastInd]);
            lastInd = hash[lastInd];
        }

        res.add(nums[lastInd]);

        Collections.sort(res);
        return res;

    }
}