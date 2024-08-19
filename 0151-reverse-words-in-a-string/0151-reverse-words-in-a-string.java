class Solution {
    public String reverseWords(String s) {
        String str[] = s.trim().split("\\s+");
        
        int i = 0, j = str.length - 1;
        
        while(i <= j) {
            String t = str[i].trim();
            str[i] = str[j].trim();
            str[j] = t;
            i++;
            j--;
        }
        
        StringBuffer sb = new StringBuffer();
        for(i = 0; i < str.length - 1; i++) {
            
            sb.append(str[i]);
            sb.append(" ");
        }
        
        sb.append(str[str.length - 1]);
        
        return sb.toString();
    }
}