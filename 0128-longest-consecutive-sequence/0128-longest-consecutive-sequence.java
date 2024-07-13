class Solution {
    public int longestConsecutive(int[] nums) {
        
        int ans = 0;
        HashSet<Integer> hs = new HashSet<>();
        
        for(int i = 0; i < nums.length; i++) {
            hs.add(nums[i]);
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(!hs.contains(nums[i] - 1)) {
                int j = nums[i];
                
                while(hs.contains(j)) {
                    j++;
                }
                
                if(ans < j - nums[i])
                    ans = j - nums[i];
            }
        }
        
        return ans;
        
    }
}