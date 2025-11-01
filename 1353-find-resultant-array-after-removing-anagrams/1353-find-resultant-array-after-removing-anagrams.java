class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        Map<Integer, int[]> hm = new HashMap<>();
        result.add(words[0]);
        int[] freq =  getFreq(words[0]);
        hm.put(0, freq);

        for(int i = 1; i < words.length; i++) {
            int[] freq1 = getFreq(words[i]);

            int[] freq2 = hm.get(result.size() - 1);

            if(!checkAnagram(freq1, freq2)) {
                result.add(words[i]);
                hm.put(result.size() - 1, freq1);
            } 

        }

        return result;
    }

    private int[] getFreq(String word) {
        int[] freq = new int[26];

        for(char c : word.toCharArray()) {
            freq[c - 'a']++;
        }

        return freq;
    }

    private boolean checkAnagram(int[] freq1, int[] freq2) {
        int count = 0;

        for(int i = 0; i < 26; i++) {
            if(freq1[i] == freq2[i]) {
                count++;
            }
        }

        return count == 26;
    }
}