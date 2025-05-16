class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {

        List<String> res = new ArrayList<>();
        int n = words.length, longSub = 1, longSubInd = 0;
        int dp[] = new int[n];
        int parent[] = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);


        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(groups[j] != groups[i] 
                    && words[j].length() == words[i].length()
                    && hammingDistance(words[j], words[i])
                    && dp[j] + 1 > dp[i]) {
                    
                    dp[i] = dp[j] + 1;
                    parent[i] = j;

                    if(dp[i] > longSub) {
                        longSub = dp[i];
                        longSubInd = i;
                    }
                } 
            }
        }

        while(longSubInd != -1) {
            res.add(words[longSubInd]);
            longSubInd = parent[longSubInd];
        }

        Collections.reverse(res);
        return res;
        
    }

    private boolean hammingDistance(String s1, String s2) {
        int ham = 0;
        for(int j = 0; j < s1.length(); j++) {
            if(s1.charAt(j) != s2.charAt(j)) {
                ham++;
            }
        }

        return ham == 1;
    }
}