class Solution {
    public boolean isPalindrome(int x) {
        int num = x, x1 = 0;
        while(num != 0) {
            x1 = (x1 *10) + (num % 10);
            num /= 10;
        }
        
        return Math.abs(x) == x1;
    }
}