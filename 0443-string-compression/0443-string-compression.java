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
                System.out.println(len);
            }
        }
        System.out.println(len);
        len = updateChar(chars, len, count, chars.length - 1);
        System.out.println(len);
        return len;
    }
    
    int updateChar(char[] chars, int len, int count, int i) {
        System.out.println("count " + count);
        chars[len] = chars[i];
        
        if(count > 1 && count <= 9) {
            chars[len + 1] = String.valueOf(count).charAt(0);
            len++;
        } else if(count > 9) {
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