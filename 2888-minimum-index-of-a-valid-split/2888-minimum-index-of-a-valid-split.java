class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size(), minInd = Integer.MAX_VALUE, maxEle = Integer.MIN_VALUE, maxFreq = Integer.MIN_VALUE;

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> freq : hm.entrySet()) {
            if (freq.getValue() > maxFreq) {
                maxFreq = freq.getValue();
                maxEle = freq.getKey();
            }
        }

        int left = 0, right = maxFreq;

        for (int i = 0; i < n - 1; i++) {
            left = maxEle == nums.get(i) ? left + 1 : left;
            right = maxFreq - left;

            if (left > (i + 1) / 2 && right > (n - i - 1) / 2) {
                return i;
            }
        }

        return -1;
    }
}