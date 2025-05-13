class Solution {
    public int lengthAfterTransformations(String s, int t) {
        int mod = 1000000007;

        int freq[] = new int[26];
        int len = 0;

        for(int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        for(int j = 0; j < t; j++) {
            int z = freq[25];

            for(int i = 25; i > 0; i--) {
                freq[i] = freq[i - 1];
            }

            freq[0] = z % mod;
            freq[1] = (freq[1] + z) % mod;
        }

        for(int i = 0; i < 26; i++) {
            len = (len + freq[i]) % mod;
        }

        return len;
    }
}