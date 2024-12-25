class Solution {
    public int maxArea(int[] height) {
        
        int max = Integer.MIN_VALUE, i = 0, j = height.length - 1;
        
        while(i < j) {
            int water = Math.min(height[i], height[j]) * (j - i);
            if(max < water) {
                max = water;
            }
            
            if(height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        
        return max;
        
    }
}