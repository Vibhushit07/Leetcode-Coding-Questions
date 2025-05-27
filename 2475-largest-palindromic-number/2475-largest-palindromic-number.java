class Solution {
    public String largestPalindromic(String num) {
        StringBuilder sb = new StringBuilder();

        int freq[] = new int[10];
        int center = -1;

        for(int i = 0; i < num.length(); i++) {
            freq[num.charAt(i) - '0']++;
        }

        for(int i = 9; i >= 0; i--) {
            if(sb.isEmpty() && center == - 1 && i == 0) {
                return "0";
            }

            if(freq[i] >= 2) {
                int f = freq[i] / 2;
                if(i != 0) {
                    for(int j = 0; j < f; j++) {
                        sb.append((char)('0' + i));
                    }
                    freq[i] %= 2;
                } else if(i == 0 && !sb.isEmpty()) {
                    for(int j = 0; j < f; j++) {
                        sb.append((char)('0' + i));
                    }
                    freq[i] %= 2;
                }
            }

            if(freq[i] == 1 && center == -1) {
                center = i;
                freq[i]--;
            }
        }

        if(center == -1) {
            return sb.toString() + sb.reverse().toString();
        }

        return sb.toString() + (char)('0' + center) + sb.reverse().toString();
    }
}