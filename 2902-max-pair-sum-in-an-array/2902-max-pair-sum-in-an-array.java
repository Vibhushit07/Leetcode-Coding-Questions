class Solution {


    public int maxSum(int[] nums) {
        int n = nums.length, maxSum = -1;
        int[] digits = getLargestDigits(nums);

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(digits[i] == digits[j]) {
                    maxSum = Math.max(maxSum, nums[i] + nums[j]);
                }
            }
        }

        return maxSum;

    }
    
    private int[] getLargestDigits(int[] nums) {
        int n = nums.length;
        int digits[] = new int[n];

        for(int i = 0; i < n; i++) {

            int lD = -1, num = nums[i];

            while(num > 0) {
                int d = num % 10;
                num /= 10;

                lD = Math.max(d, lD);
            }

            digits[i] = lD;
        }

        return digits;
    }

}
