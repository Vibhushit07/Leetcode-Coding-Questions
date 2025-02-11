class Solution {
    public String removeOccurrences(String s, String part) {
        
        Stack<Character> st = new Stack<>();
        char res[] = new char[s.length()];
        int pLen = part.length(), resLen = 0;
        char pLast = part.charAt(pLen - 1);

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
             res[resLen++] = c;

            if(c == pLast && resLen >= pLen) {
               int j = resLen - 1, k = pLen - 1;

                while(k >= 0 && res[j] == part.charAt(k)) {
                    j--;
                    k--;
                }

                if(k < 0) {
                    resLen = j + 1;
                }
            }
        }
        return new String(res, 0, resLen);
    }
}