class Solution {
    public int numOfSubarrays(int[] arr) {
        int odd = 0, even = 0, totalOdd = 0, sum = 0;

        for(int a : arr) {
            sum += a;

            if(sum % 2 == 0) {
                totalOdd = (totalOdd + odd) % 1000000007;
                even++;
            } else {
                totalOdd = (totalOdd + even + 1) % 1000000007;
                odd++;
            }
        }

        return totalOdd;
    }
}