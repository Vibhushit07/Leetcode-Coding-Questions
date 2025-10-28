class Solution {
    public long maximumTotalDamage(int[] power) {
        Map<Long, Long>freq = new HashMap<>();
        
        for(int num : power) {
            freq.put((long)num, freq.getOrDefault((long)num, 0l) + 1);
        }

        List<Long> nums = new ArrayList<>(freq.keySet());
        Collections.sort(nums);

        long[] dp = new long[nums.size()];
        Arrays.fill(dp, -1);

        return solve(nums, dp, freq, 0);
    }

    private int lowerBound(List<Long> nums, int start, long target) {
        int l = start, r = nums.size();

        while(l < r) {
            int mid = (r + l) / 2;
            if(nums.get(mid) < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }

    private long solve(List<Long> nums, long[] dp, Map<Long, Long>freq, int i) {
        if(i >= nums.size()) {
            return 0;
        }

        if(dp[i] != -1) {
            return dp[i];
        }

        long skip = solve(nums, dp, freq, i + 1);

        int j = lowerBound(nums, i + 1, nums.get(i) + 3);
        long take = nums.get(i) * freq.get(nums.get(i)) + solve(nums, dp, freq, j);

        dp[i] = Math.max(skip, take);

        return dp[i];
    }
}