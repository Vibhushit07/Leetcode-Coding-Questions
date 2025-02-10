class Solution {
    public String clearDigits(String s) {
        boolean isDeleted[] = new boolean[s.length()];
        String res = "";

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                isDeleted[i] = true;
                int j = i - 1;
                while(j >= 0) {
                    if(s.charAt(j) >= 'a' && s.charAt(j) <= 'z' && !isDeleted[j]) {
                        isDeleted[j] = true;
                        break;
                    }
                    j--;
                }
            }
        }

        for(int i = 0; i < s.length(); i++) {
            if(!isDeleted[i]) {
                res += s.charAt(i);
            }
        }

        return res;
    }
}