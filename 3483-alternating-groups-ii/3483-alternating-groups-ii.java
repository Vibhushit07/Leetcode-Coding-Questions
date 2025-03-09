class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        
        int len = 1, count = 0, n = colors.length;

        for(int i = 1; i <= n + k - 2; i++) {

            if(colors[i % n] != colors[(i - 1 + n) % n]) {
                len++;
            } else {
                len = 1;
            }

            if(len >= k) {
                count++;
            }
        }

        return count;
    }
}