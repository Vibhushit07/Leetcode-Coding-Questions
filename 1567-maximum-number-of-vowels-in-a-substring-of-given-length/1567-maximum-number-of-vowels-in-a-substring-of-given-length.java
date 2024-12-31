class Solution {
    public int maxVowels(String s, int k) {
        int vow = 0, max = 0, i = 0;

        while(i < k) {
            if(checkVowel(s.charAt(i++))) {
                vow++;
            }
        }

        max = Math.max(vow, max);

        while(i < s.length()) {
            if(checkVowel(s.charAt(i - k))) {
                vow--;
            }

            if(checkVowel(s.charAt(i++))) {
                vow++;
            }

            max = Math.max(vow, max);
        }

        return max;
    }

    private boolean checkVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}