class Solution {
    public int hammingWeight(int n) {
        int num = n, res = 0;
        
        while(num > 0) {
            num = num & (num - 1);
            res++;
        }
        
        return res;
    }
}