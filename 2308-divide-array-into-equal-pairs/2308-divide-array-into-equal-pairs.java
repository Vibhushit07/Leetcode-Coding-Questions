class Solution {
    public boolean divideArray(int[] nums) {
        int freq[] = new int[501];

        int count = 0;

        for(int i = 0; i < nums.length; i++) {
            freq[nums[i]]++;
        }

        for(int i = 1; i <= 500; i++) {
            if(freq[i] % 2 != 0) {
                return false;
            } else {
                count += freq[i] / 2;
            }
        }

        return count == nums.length / 2;
    }
}