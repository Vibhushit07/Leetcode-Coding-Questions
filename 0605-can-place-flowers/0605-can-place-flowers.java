class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int l = flowerbed.length, count = 0, i = 0;
        
        if(n == 0)
            return true;
        
        if(l == 1) {
            if(n == 1)
                return flowerbed[0] == 0;
            else 
                return false;
        }
        
        while(i < l) {
            if(i == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                count++;
                i++;
            } else if(i > 0) {
                
                if((i == l - 1 && flowerbed[i - 1] == 0 && flowerbed[i] == 0) || 
                  flowerbed[i - 1] == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                    
                    count++;
                    i++;
                }

            }
            
            i++;
            
            if(count == n) {
                return true;
            }
            
        }
        
        return count == n;
    }
}