class Solution {
    public int largestAltitude(int[] gain) {
        
        int alt = 0, max = 0;
        
        for(int i = 0; i < gain.length; i++) {
            alt += gain[i];
            
            if(alt > max) {
                max = alt;
            }
        }
        
        return max;
        
    }
}