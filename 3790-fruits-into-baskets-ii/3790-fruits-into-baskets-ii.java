class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int count = 0, n = baskets.length;
        boolean placed[] = new boolean[n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!placed[j] && baskets[j] >= fruits[i]) {
                    placed[j] = true;
                    count++;
                    break;
                }
            }
        }

        return n - count;
    }
}