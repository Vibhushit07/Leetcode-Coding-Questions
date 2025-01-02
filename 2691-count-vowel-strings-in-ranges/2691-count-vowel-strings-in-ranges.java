class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        
        int qL = queries.length, wL = words.length;
        
        int preSum[] = new int[wL];
        int ans[] = new int[qL];

        for(int i = 0; i < wL; i++) {
            if(isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(words[i].length() - 1))) {
                preSum[i] = i == 0 ? 1 : preSum[i - 1] + 1;
            } else {
                preSum[i] = i == 0 ? 0 : preSum[i - 1];
            }
        }

        for(int i = 0; i < qL; i++) {
            int l = queries[i][0], r = queries[i][1];
            if(l == 0) {
                ans[i] = preSum[r];
            } else {
                ans[i] = preSum[r] - preSum[l - 1];
            }
        }

        return ans;
    }

    boolean isVowel(char c) {
        return c == 'a' ||
            c == 'e' ||
            c == 'i' || 
            c == 'o' ||
            c == 'u';
    }
}