class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int prevLen = 0, currLen = 1, res = 0;

        for(int i = 1; i < nums.size(); i++) {
            if(nums.get(i) > nums.get(i - 1)) {
                currLen++;
            } else {
                prevLen = currLen;
                currLen = 1;
            }

            if(currLen >= 2 * k) {
                return true;
            }

            if(Math.min(currLen, prevLen) >= k) {
                return true;
            }
        }

        return false;
    }
}