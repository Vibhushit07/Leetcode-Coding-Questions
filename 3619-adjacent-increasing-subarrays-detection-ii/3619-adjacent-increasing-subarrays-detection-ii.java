class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int maxLen = 0, prevLen = 0, currLen = 1;

        for(int i = 1; i < nums.size(); i++) {
            if(nums.get(i) > nums.get(i - 1)) {
                currLen++;
            } else {
                prevLen = currLen;
                currLen = 1;
            }
            maxLen = Math.max(maxLen, currLen / 2);
            maxLen = Math.max(maxLen, Math.min(prevLen, currLen));
        }

        return maxLen;
    }
}