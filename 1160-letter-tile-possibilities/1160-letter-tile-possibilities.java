class Solution {
    public int numTilePossibilities(String tiles) {

        int[] freq = new int[26];

        for(int i = 0; i < tiles.length(); i++) {
            freq[tiles.charAt(i) - 'A']++;
        }

        return sequences(freq);
    }

    private int sequences(int[] freq) {
        int count = 0;

        for(int i = 0; i < 26; i++) {
            if(freq[i] > 0) {
                freq[i]--;
                count += 1 + sequences(freq);
                freq[i]++;
            }
        }

        return count;
    }
}