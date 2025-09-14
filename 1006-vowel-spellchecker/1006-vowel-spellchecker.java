class Solution {
    public String[] spellchecker(String[] wordList, String[] queries) {
        Set<String> exactMatch = new HashSet<>(Arrays.asList(wordList));
        Map<String, String> lowerCase = new HashMap<>();
        Map<String, String> vowelError = new HashMap<>();

        int wLen = wordList.length, qLen = queries.length;

        String[] result = new String[qLen];

        for(String word : wordList) {
            String lower = toLower(word);
            String vowel = deVowel(lower);

            lowerCase.putIfAbsent(lower, word);
            vowelError.putIfAbsent(vowel, word);
        }

        for(int i = 0; i < qLen; i++) {
            String q = queries[i];
            String lower = toLower(q);
            String vowel = deVowel(lower);

            if (exactMatch.contains(q)) {
                result[i] = q;

            } else if (lowerCase.containsKey(lower)) {
                result[i] = lowerCase.get(lower);

            } else if (vowelError.containsKey(vowel)) {
                result[i] = vowelError.get(vowel);

            } else {
                result[i] = "";
            }
        }

        return result;
    }

    String toLower(String word) {
        return word.toLowerCase();
    }

    String deVowel(String word) {
        char w[] = word.toCharArray();

        for(int i = 0; i < w.length; i++) {
            if(isVowel(w[i])) {
                w[i] = '*';
            }
        }

        return new String(w);
    }

    boolean isVowel(char c) {
        return c == 'a' ||
            c == 'e' ||
            c == 'i' ||
            c == 'o' ||
            c == 'u';
    }
}