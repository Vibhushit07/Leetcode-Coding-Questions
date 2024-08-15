class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hs = new HashMap<>();
        int max = nums[0], maxCount = 1;
        
        for(int i = 0; i < nums.length; i++) {
            hs.put(nums[i], hs.getOrDefault(nums[i], 0) + 1);
            
            if(maxCount < hs.get(nums[i])) {
                maxCount = hs.get(nums[i]);
                max = nums[i];
            }
        }
        
        return max;
    }
}