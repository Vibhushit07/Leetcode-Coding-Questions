class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap();
        HashSet<Integer> hs = new HashSet();
        
        for(int i = 0; i < arr.length; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }

        for(Map.Entry<Integer, Integer> map : hm.entrySet()) {
            if(hs.contains(map.getValue())) {
                return false;
            }

            hs.add(map.getValue());
        }

        return true;
    }
}