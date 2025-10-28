class Solution {
    public long maximumTotalDamage(int[] power) {
        Map<Long, Long>freq = new HashMap<>();
        long result = 0;
        
        for(int num : power) {
            freq.put((long)num, freq.getOrDefault((long)num, 0l) + 1);
        }

        List<Long> nums = new ArrayList<>(freq.keySet());
        Collections.sort(nums);
        int n = nums.size();

        long[] dp = new long[nums.size()];
        Arrays.fill(dp, -1);

        for(int i = n - 1; i >= 0; i--) {
            long skip = (i + 1 >= n) ? 0 : dp[i + 1];

            int j = lowerBound(nums, i + 1, nums.get(i) + 3);
            long take = nums.get(i) * freq.get(nums.get(i)) + ((j >= n) ? 0 : dp[j]);

            dp[i] = Math.max(skip, take);
            result = dp[i];
        }

        return result;
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
}