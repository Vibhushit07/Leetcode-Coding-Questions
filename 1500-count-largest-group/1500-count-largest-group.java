class Solution {
    public int countLargestGroup(int n) {

        if (n < 10) {
            return n;
        }

        HashMap<Integer, Integer> hm = getDigitSum(n);
        int maxSize = 0, count = 0;

        for (Map.Entry<Integer, Integer> map : hm.entrySet()) {
            int size = map.getValue();
            if (maxSize == size) {
                count++;
            } else if (maxSize < size) {
                maxSize = size;
                count = 1;
            }
        }

        return count;
    }

    private HashMap<Integer, Integer> getDigitSum(int n) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            int sum = getSum(i);

            int count = hm.getOrDefault(sum, 0) + 1;
            hm.put(sum, count);
        }

        return hm;

    }

    private int getSum(int num) {
        int n = num, sum = 0;

        while (n > 0) {
            int d = n % 10;
            sum += d;
            n /= 10;
        }

        return sum;
    }
}