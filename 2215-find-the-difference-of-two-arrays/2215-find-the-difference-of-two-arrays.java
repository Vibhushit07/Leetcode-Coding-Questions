class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> res = new ArrayList<>();
        
        HashMap<Integer, Boolean> hm1 = new HashMap<>();
        HashMap<Integer, Boolean> hm2 = new HashMap<>();
        
        int n1 = nums1.length, n2 = nums2.length;
        
        for(int i = 0; i < 2; i++) {
            res.add(new ArrayList());
        }
        
        for(int i = 0; i < n1; i++) {
            hm1.put(nums1[i], true);
        }
        
        for(int i = 0; i < n2; i++) {
            hm2.put(nums2[i], true);
        }
        
        for(int i = 0; i < n1; i++) {
            if(!hm2.containsKey(nums1[i]) && !res.get(0).contains(nums1[i])) {
                res.get(0).add(nums1[i]);
                // hm2.put(nums1[i], false);
                
            // } else if (!hm2.containsKey(nums1[i])) {
            //     res.get(0).add(nums1[i]);
            }
        }
        
        for(int i = 0; i < n2; i++) {
            if(!hm1.containsKey(nums2[i]) && !res.get(1).contains(nums2[i])) {
                res.get(1).add(nums2[i]);
//                 hm1.put(nums2[i], false);
                
//             } else if(!hm1.containsKey(nums2[i])) {
//                 res.get(1).add(nums2[i]);
            }
        }
        
        return res;
    }
}