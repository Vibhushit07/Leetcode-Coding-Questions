class Solution {
    public int[] getNoZeroIntegers(int n) {

        if(n == 1) {
            return new int[]{1, 1};
        }

        for(int i = 1; i <= n; i++) {
            int a = i, b = n - i;

            if(checkNoZero(a) && checkNoZero(b)) {
                return new int[]{a, b};
            }
        }

        return new int[]{-1, -1};
    }

    boolean checkNoZero(int num) {
        int n = num;

        while(n > 0) {
            int d = n % 10;
            n /= 10;

            if(d == 0) {
                return false;
            }
        }

        return true;
    }
}