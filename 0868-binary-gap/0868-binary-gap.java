class Solution {
    public int binaryGap(int n) {
        int dis = 0, j = -1;

        for(int i = 0; i < 32; i++) {
            if(((n >> i) & 1) == 1) {
                if(j != -1) {
                    dis = Math.max(dis, i - j);
                }

                j = i;
            } 
        }

        return dis;
    }
}