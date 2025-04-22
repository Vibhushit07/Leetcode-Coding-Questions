class Solution {

    class Pair {
        int first, second;

        Pair(int f, int s) {
            first = f;
            second = s;
        }

        int getFirst() {
            return first;
        }

        int getSecond() {
            return second;
        }
    }

    public int maxSum(int[] nums) {
        int n = nums.length, maxSum = -1;
        HashMap<Integer, Pair> digits = getLargestDigitsPair(nums);

        for(Map.Entry<Integer, Pair> map : digits.entrySet()) {
             Pair pair = map.getValue();
            if(pair.first != -1) {
                maxSum = Math.max(maxSum, pair.getFirst() + pair.getSecond());
            }
        }

        return maxSum;
    }
    
    private HashMap<Integer, Pair> getLargestDigitsPair(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Pair> digits = new HashMap<>();

        for(int i = 0; i < n; i++) {

            int lD = -1, num = nums[i];

            while(num > 0) {
                int d = num % 10;
                num /= 10;

                lD = Math.max(d, lD);
            }

            Pair pair = digits.getOrDefault(lD, new Pair(-1, -1));

            if(pair.getSecond() < nums[i]) {
                pair.first = pair.second;
                pair.second = nums[i];

            } else if (pair.getFirst() < nums[i]) {
                pair.first = nums[i];
            }

            digits.put(lD, pair);
        }

        return digits;
    }

}