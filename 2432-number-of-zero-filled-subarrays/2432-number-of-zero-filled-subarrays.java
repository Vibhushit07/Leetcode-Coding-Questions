class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long totalCount = 0l, count = 0l;


        for(int n : nums) {
            if(n == 0) {
                count++;
            } else {
                totalCount += (count * (count + 1) / 2);
                count = 0;
            }
        }

        totalCount += (count * (count + 1) / 2);

        return totalCount;
    }
}