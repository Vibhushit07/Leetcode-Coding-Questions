class Solution {
    public long countBadPairs(int[] nums) {
        
        long n = nums.length;
        long totalPair = n * (n - 1) / 2;
        HashMap<Integer, Long> diffCount = new HashMap<>();
        long count = 0;

        for(int i = 0; i < n; i++) {
            int diff = nums[i] - i;
            Long c = diffCount.getOrDefault(diff, 0L);
            count += c;
            diffCount.put(diff, c + 1);
        }

        return totalPair - count;
    }
}