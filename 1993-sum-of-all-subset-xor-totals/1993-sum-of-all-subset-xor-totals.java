class Solution {
    public int subsetXORSum(int[] nums) {
        int orTotal = 0, n = nums.length;

        for(int num : nums) {
            orTotal |= num;
        }

        return (1 << n - 1) * orTotal;
    }
}