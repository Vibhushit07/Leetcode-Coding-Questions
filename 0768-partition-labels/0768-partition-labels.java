class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int[] lastIndex = new int[26];
        int size = 0, end = 0;

        Arrays.fill(lastIndex, -1);

        for(int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        for(int i = 0; i < s.length(); i++) {
            size++;
            end = Math.max(end, lastIndex[s.charAt(i) - 'a']);

            if(i == end) {
                res.add(size);
                size = 0;
            }
        }

        return res;
    }
}