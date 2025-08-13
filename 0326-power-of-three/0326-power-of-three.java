class Solution {
    public boolean isPowerOfThree(int n) {
        if(n <= 0)
            return false;
        if(n == 1 || n == 3) 
            return true;
        
        int num = n;

        while(num > 1) {

            int rem = num % 3;

            if(rem != 0) 
                return false;

            num /= 3;
        }

        return true;
    }
}