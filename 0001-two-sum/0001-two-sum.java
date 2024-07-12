class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int res[] = new int[2];
        
        for(int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];
            if(hm.containsKey(sub)) {
                res[0] = hm.get(sub);
                res[1] = i;
                break;
            }
            
            hm.put(nums[i], i);
        }
        
        return res;
    }
}