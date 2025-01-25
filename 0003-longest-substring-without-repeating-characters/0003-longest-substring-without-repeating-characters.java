class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs = new HashSet<>();
        int maxLen = 0, i = 0, j = 0, len = s.length();

        while(j < len) {
            if(!hs.contains(s.charAt(j))) {
                hs.add(s.charAt(j));
                maxLen = Math.max(j - i + 1, maxLen);
                j++;
            } else {
                do {
                    hs.remove(s.charAt(i));
                } while((s.charAt(i++) != s.charAt(j)));
            }
        }

        return maxLen;
    }
}