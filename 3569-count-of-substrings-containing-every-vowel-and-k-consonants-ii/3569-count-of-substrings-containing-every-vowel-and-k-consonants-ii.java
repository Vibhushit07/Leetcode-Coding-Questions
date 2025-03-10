class Solution {
    public long countOfSubstrings(String word, int k) {
        return countSubstrings(word, k) - countSubstrings(word, k + 1);
    }

    private long countSubstrings(String s, int k) {
		int left = 0, right = 0, n = s.length(), cons = 0;
        long count = 0;
		HashMap<Character, Integer> hm = new HashMap<>();

		while(right < n) {
			char c = s.charAt(right);
			if(isVowel(c)) {
				hm.put(c, hm.getOrDefault(c, 0) + 1);
			} else {
				cons++;
			}

			while(hm.size() == 5 && cons >= k) {
				char t = s.charAt(left);
                count += n - right;
				if(isVowel(t)) {
					hm.put(t, hm.get(t) - 1);
					if(hm.get(t) == 0) {
						hm.remove(t);
					}
				} else {
					cons--;
				}
                left++;
			}

			right++;
		}
		return count;
	}

    private Boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}