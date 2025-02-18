class Solution {
    public String smallestNumber(String pattern) {
        String res = "";
        int i = 0;
        int countD = 0;
        String d = "";

        while (i < pattern.length()) {

            if (pattern.charAt(i) == 'I') {
                if (countD != 0) {
                    d += String.valueOf(i + 1);
                    res += reverse(d);
                    d = "";
                    countD = 0;
                } else {
                    res += String.valueOf(i + 1);
                }
            } else {
                d += String.valueOf(i + 1);
                countD++;
            }
            i++;
        }

        if(!d.equals("")) {
            d += String.valueOf(i + 1);
            res += reverse(d);
        } else {
            res += String.valueOf(i + 1);
        }

        return res;
    }

    private String reverse(String str) {
        char s[] = str.toCharArray();

        int i = 0, j = s.length - 1;

        while(i < j) {
            char c = s[i];
            s[i] = s[j];
            s[j] = c;
            j--;
            i++;
        }

        return new String(s);
    }
}