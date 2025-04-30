class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;

        for(int num : nums) {
            if(evenDigits(num)) {
                count++;
            }
        }

        return count;
    }

    private boolean evenDigits(int num) {
        int n = num, digits = 0;

        while(n > 0) {
            n /= 10;
            digits++;
        }

        return digits % 2 == 0;
    }
}