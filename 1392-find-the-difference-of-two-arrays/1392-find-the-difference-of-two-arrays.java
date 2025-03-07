class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> res = new ArrayList<>();
        
        HashSet<Integer> hm1 = new HashSet<>();
        HashSet<Integer> hm2 = new HashSet<>();
        
        int n1 = nums1.length, n2 = nums2.length;
        
        for(int i = 0; i < 2; i++) {
            res.add(new ArrayList());
        }
        
        for(int i = 0; i < n1; i++) {
            hm1.add(nums1[i]);
        }
        
        for(int i = 0; i < n2; i++) {
            hm2.add(nums2[i]);
        }
        
        for(int i = 0; i < n1; i++) {
            if(!hm2.contains(nums1[i]) && !res.get(0).contains(nums1[i])) {
                res.get(0).add(nums1[i]);
            }
        }
        
        for(int i = 0; i < n2; i++) {
            if(!hm1.contains(nums2[i]) && !res.get(1).contains(nums2[i])) {
                res.get(1).add(nums2[i]);
            }
        }
        
        return res;
    }
}