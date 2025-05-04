class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {

        int count = 0, n = dominoes.length;

        HashMap<String, Integer> hm = new HashMap<>();

        for(int i = 0; i < n; i++) {
            int a = Math.min(dominoes[i][0], dominoes[i][1]);
            int b = Math.max(dominoes[i][0], dominoes[i][1]);
            String key = a + "," + b;

            int freq = hm.getOrDefault(key, 0);
            freq++;
            hm.put(key, freq);

            System.out.println(hm);
        }

        for(int freq : hm.values()) {
            count += (freq * (freq - 1)) / 2;
        }

        return count;
    }
}