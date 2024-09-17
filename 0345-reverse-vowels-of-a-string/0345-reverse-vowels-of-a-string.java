class Solution {
    
    boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
            || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
    
    public String reverseVowels(String s) {
        
        char str[] = s.toCharArray();
        
        int i = 0, j = str.length - 1;
        
        while(i < j) {
            boolean start = isVowel(str[i]);
            boolean end = isVowel(str[j]);
            
            if(start && end) {
                char c = str[i];
                str[i] = str[j];
                str[j] = c;
                i++;
                j--;
            } else if(!start) {
                i++;
            } else if(!end) {
                j--;
            }
        }
        
        return new String(str);
        
    }
}