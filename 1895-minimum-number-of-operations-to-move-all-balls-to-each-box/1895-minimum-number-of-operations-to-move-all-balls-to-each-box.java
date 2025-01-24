class Solution {
    public int[] minOperations(String boxes) {
        
        int n = boxes.length();
        int res[] = new int[n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i != j && boxes.charAt(j) == '1') {
                    res[i] += Math.abs(j - i);
                }
            }
        }

        return res;
    }
}