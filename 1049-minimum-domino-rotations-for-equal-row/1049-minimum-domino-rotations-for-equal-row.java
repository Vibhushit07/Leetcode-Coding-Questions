class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int freq[] = new int[7];
        int n = tops.length, t = 0, b = 0, val = 0;
        boolean flag = false;

        for(int i = 0; i < n; i++) {
            if(tops[i] != bottoms[i]) {
                freq[bottoms[i]]++;
            } 
            freq[tops[i]]++;
        }

        for(int i = 1; i < 7; i++) {
            if(freq[i] == n) {
                flag = true;
                val = i;
                break;
            }
        }

        if(!flag) {
            return -1;
        }

        for(int i = 0; i < n; i++) {
            if(tops[i] == val && bottoms[i] != val) {
                b++;
            } else if (tops[i] != val && bottoms[i] == val) {
                t++;
            }
        }

        return Math.min(t, b);
    }
}