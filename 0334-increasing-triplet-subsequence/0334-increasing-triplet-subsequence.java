class Solution {
    public boolean increasingTriplet(int[] nums) {
        
        int small = Integer.MAX_VALUE, middle = Integer.MAX_VALUE;
        
        for(int n : nums) {
            if(n > middle) {
                return true;
            }
            
            if(n <= small) {
                small = n;
            } else {
                middle = n;
            }
        }
        
        return false;
    }
}