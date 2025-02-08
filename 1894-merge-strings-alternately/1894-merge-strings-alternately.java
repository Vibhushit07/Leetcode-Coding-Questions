class Solution {
    public String mergeAlternately(String word1, String word2) {
        
        int n1 = word1.length(), n2 = word2.length();
        char[] word = new char[n1 + n2];
        
        int i = 0, j = 0, k = 0;
        
        while(i < n1 && j < n2) {
            word[k++] = word1.charAt(i++);
            word[k++] = word2.charAt(j++);
        }
        
        while(i < n1) {
            word[k++] = word1.charAt(i++);
        }
        
        while(j < n2) {
            word[k++] = word2.charAt(j++);
        }
        
        return new String(word);
    }
}