class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length, j = 0;

        int[] res = new int[n - k + 1];

        Map<Integer, Integer> hm = new HashMap<>();

        for(int i = 0; i < k; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }

        res[j++] = xSum(hm, x);

        for(int i = k; i < n; i++) {
            hm.put(nums[i - k], hm.getOrDefault(nums[i - k], 0) - 1);
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);

            res[j++] = xSum(hm, x);
        }

        return res;
    }

    int xSum(Map<Integer, Integer> hm, int x) {
        int sum = 0;
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(hm.entrySet());

        Comparator<Map.Entry<Integer, Integer>> comp = (entry1, entry2) -> {
            int compare = entry2.getValue().compareTo(entry1.getValue());

            if(compare == 0) {
                return entry2.getKey().compareTo(entry1.getKey());
            } else {
                return compare;
            }
        };

        list.sort(comp);

        for(int i = 0; i < list.size() && i < x; i++) {
            Map.Entry<Integer, Integer> entry = list.get(i);
            sum += entry.getKey() * entry.getValue();
        }

        return sum;
    }
}