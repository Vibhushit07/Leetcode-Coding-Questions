class Solution {
    public int maximumSum(int[] nums) {

        int maxSum = 0;
        HashMap<Integer, Integer> digitSum = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int sum = sumOfDigits(nums[i]);

            if(!digitSum.containsKey(sum)) {
                digitSum.put(sum, nums[i]);
            } else {
                int num = digitSum.get(sum);
                maxSum = Math.max(maxSum, num + nums[i]);
                num = Math.max(num, nums[i]);
                digitSum.put(sum, num);
            }
        }

        return maxSum == 0 ? -1 : maxSum;
        
    }

    private int sumOfDigits(int num) {
        int sum = 0;

        while(num > 0) {
            sum += (num % 10);
            num /= 10;
        }

        return sum;
    }
}