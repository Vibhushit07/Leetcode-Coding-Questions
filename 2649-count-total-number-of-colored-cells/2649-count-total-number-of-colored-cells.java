class Solution {
    public long coloredCells(int n) {

        if(n == 1)
            return 1l;
        
        return 2L * n * (n-1) + 1; 
    }
}