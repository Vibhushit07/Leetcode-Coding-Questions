class Solution {
    public String sortVowels(String s) {
        char arr[] = s.toCharArray();
        List<Character> vowels = new ArrayList<>();

        for(char c : arr) {
            if(isVowel(c)) {
                vowels.add(c);
            }
        }

        Collections.sort(vowels);
        int j = 0;

        for(int i = 0; i < arr.length; i++) {
            if(isVowel(arr[i])) {
                arr[i] = vowels.get(j++);
            }
        }

        return new String(arr);

    }

    private boolean isVowel(char c) {
        return c == 'A' || c == 'a' 
            || c == 'E' || c == 'e'
            || c == 'I' || c == 'i'
            || c == 'O' || c == 'o'
            || c == 'U' || c == 'u';
    }
}