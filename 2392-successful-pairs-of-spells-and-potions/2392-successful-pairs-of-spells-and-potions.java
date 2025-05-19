class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {

        int n = spells.length, m = potions.length;
        int res[] = new int[n];
        Arrays.sort(potions);

        for(int i = 0; i < n; i++) {
            int l = 0, r = m - 1;
            int max = 0;

            while(l <= r) {
                int mid = l + (r - l) / 2;
                if((long) spells[i] * potions[mid] >= success) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }

            res[i] = m - l;
        }

        return res;
        
    }
}