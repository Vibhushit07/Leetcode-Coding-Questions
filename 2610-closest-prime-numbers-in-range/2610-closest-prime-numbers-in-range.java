class Solution {
    public int[] closestPrimes(int left, int right) {

        int res[] = new int[2];
        int minDiff = Integer.MAX_VALUE;

        List<Integer> list = new ArrayList<>();

        for(int i = left; i <= right; i++) {
            if(isPrime(i)) {
                list.add(i);
            }
        }

        if(list.size() < 2) {
            return new int[]{-1, -1};
        }

        for(int i = 0; i < list.size() - 1; i++) {
            int diff = list.get(i + 1) - list.get(i);

            if(diff < minDiff) {
                minDiff = diff;
                res[0] = list.get(i);
                res[1] = list.get(i + 1);
            }
        }

        return res;
        
    }

    private boolean isPrime(int n) {

        if(n == 1)
            return false;

        if(n == 2 || n == 3) {
            return true;
        }

        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0)
                return false;
        }

        return true;
    }
}