class Solution {
    public int numberOfSubstrings(String s) {
        int count = 0, left = 0, right = 0, n = s.length();
        int []freq = new int[3];

        while(right < n) {
            char c = s.charAt(right);

            freq[c - 'a']++;

            while(freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                count += n - right;
                freq[s.charAt(left) - 'a']--;
                left++;
            }

            right++;
        }

        return count;
    }
}