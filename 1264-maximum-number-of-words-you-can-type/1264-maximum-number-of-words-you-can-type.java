class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] texts = text.split(" ");
        int words = 0;

        for(String t : texts) {
            boolean hasCommon = brokenLetters.chars()
                .anyMatch(ch -> t.indexOf(ch) >= 0);

            if(!hasCommon) {
                words++;
            }
        }

        return words;
    }
}