class Solution {
    public int compress(char[] chars) {
        int count = 1;
        int len = 0;
        
        for(int i = 1; i < chars.length; i++) {
            if(chars[i] == chars[i - 1]) {
                count++;
            } else {
                len = updateChar(chars, len, count, i - 1);
                count = 1;
            }
        }
        len = updateChar(chars, len, count, chars.length - 1);
        return len;
    }
    
    int updateChar(char[] chars, int len, int count, int i) {
        
        chars[len] = chars[i];
        
        if(count > 1 ) {
            char co[] = String.valueOf(count).toCharArray();
            for(int j = 0; j < co.length; j++) {
                chars[len + j + 1] = co[j];
            }
            len += co.length;
        }
        
        len++;
        return len;
    }
}