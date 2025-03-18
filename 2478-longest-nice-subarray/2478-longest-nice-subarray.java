class Solution {
    public int longestNiceSubarray(int[] nums) {
        int num = nums[0], length = 1, j = 0;

        for(int i = 1; i < nums.length; i++) {
            while((num & nums[i]) != 0 && j < i) {
                num ^= nums[j++];
            }

            num ^= nums[i];

            length = Math.max(length, i - j + 1);
        }

        return length;
    }
}