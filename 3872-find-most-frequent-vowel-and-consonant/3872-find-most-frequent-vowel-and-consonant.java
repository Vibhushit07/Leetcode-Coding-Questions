class Solution {
    public int maxFreqSum(String s) {
        int maxV = 0, maxC = 0;

        int freq[] = new int[26];

        for(int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < 26; i++) {
            char c = (char)('a' + i);

            if(isVowel(c)) {
                maxV = Math.max(maxV, freq[i]);
            } else {
                maxC = Math.max(maxC, freq[i]);
            }
        }

        return maxV + maxC;
    }

    boolean isVowel(char c) {
        return c == 'a' ||
            c == 'e' ||
            c == 'i' ||
            c == 'o' ||
            c == 'u';
    }
}