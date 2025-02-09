class Solution {
    public long countBadPairs(int[] nums) {
        
        long n = nums.length;
        long totalPair = n * (n - 1) / 2;
        HashMap<Integer, Long> diffCount = new HashMap<>();

        for(int i = 0; i < n; i++) {
            int diff = nums[i] - i;
            Long count = diffCount.getOrDefault(diff, 0L);
            totalPair -= count;
            diffCount.put(diff, count + 1);
        }

        return totalPair;
    }
}