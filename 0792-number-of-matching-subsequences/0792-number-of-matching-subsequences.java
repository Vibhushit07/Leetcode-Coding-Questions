class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Map<Character, List<Integer>> hm = new HashMap<>();

        for(int i = 0 ; i < s.length(); i++) {
            char c = s.charAt(i);
            List<Integer> indecies = hm.getOrDefault(c, new ArrayList<>());
            indecies.add(i);
            hm.put(c, indecies);
        }

        int count = 0;

        for(int i = 0; i < words.length; i++) {
            int prev = -1;
            boolean found = true;

            for(char c : words[i].toCharArray()) {
                if(!hm.containsKey(c)) {
                    found = false;
                    break;
                }

                List<Integer> indecies = hm.get(c);

                int ind = Collections.binarySearch(indecies, prev + 1);

                if (ind < 0) {
                    ind = -(ind + 1);
                }

                if (ind == indecies.size()) {
                    found = false;
                    break;
                }

                prev = indecies.get(ind);
            }

            if(found) {
                count++;
            }
        }

        return count;
    }
}