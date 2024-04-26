class myComp implements Comparator <Map.Entry<Integer, Integer>> {
    public int compare(Map.Entry<Integer, Integer> m1, Map.Entry<Integer, Integer> m2) {
        if(m1.getValue() == m2.getValue()) {
            return m1.getKey() - m2.getKey();
        } else {
            return m2.getValue() - m1.getValue();
        }
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 1) + 1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new myComp());
        
        // for(Map.Entry<Integer, Integer> m : map) {
        //     pq.add(m);
        // }
        
        map.entrySet().stream().forEach(entry -> pq.add(entry));
        
        int arr[] = new int[k];
        for(int i = 0; i < k; i++) {
            arr[i] = pq.poll().getKey();
        }
        return arr;
    }
}