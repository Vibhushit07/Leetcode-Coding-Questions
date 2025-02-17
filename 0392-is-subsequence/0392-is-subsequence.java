class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() > t.length())
            return false;
        if(s.equals(t))
            return true;

        int count = 0, i = 0, j = 0;

        while(i < s.length() && j < t.length()) {
            if(s.charAt(i) == t.charAt(j)) {
                count++;
                i++;
            }

            j++;
        }

        return count == s.length();
    }
}