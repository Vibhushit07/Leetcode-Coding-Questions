class Solution {
    public long putMarbles(int[] weights, int k) {
        long max = 0, min = 0;
        List<Integer> pairSum = new ArrayList<>();

        for(int i = 0; i < weights.length - 1; i++) {
            pairSum.add(weights[i] + weights[i + 1]);
        }

        Collections.sort(pairSum);
        int n = pairSum.size();

        for(int i = 0; i < k - 1; i++) {
            min += (long)pairSum.get(i);
            max += (long)pairSum.get(n - 1 - i);
        }

        return max - min;
    }
}