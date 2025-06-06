class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> freqMap = new HashMap<>();
        int len = 0;
        boolean oddUsed = false;

        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        for (String word : words) {
            String rev = reverse(word);
            int wordcount = freqMap.get(word);
            int revCount = 0;

            if(freqMap.containsKey(rev)) {
                revCount = freqMap.get(rev);
            }

            if (!word.equals(rev) && wordcount > 0 && revCount > 0) {
                len += 4;
                freqMap.put(word, wordcount - 1);
                freqMap.put(rev, revCount - 1);

            } else if (word.equals(rev) && wordcount >= 2) {
                len += 4;
                freqMap.put(word, wordcount - 2);

            } else if (word.equals(rev) && wordcount > 0 && !oddUsed) {
                len += 2;
                freqMap.put(word, wordcount - 1);
                oddUsed = true;
            }
        }

        return len;
    }

    private String reverse(String str) {
        String s = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            s += str.charAt(i);
        }

        return s;
    }
}