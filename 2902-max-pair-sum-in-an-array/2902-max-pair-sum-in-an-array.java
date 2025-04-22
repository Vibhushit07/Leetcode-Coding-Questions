class Solution {

    public int maxSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, maxSum = -1;
        HashMap<Integer, List<Integer>> digits = getLargestDigits(nums);

        for(Map.Entry<Integer, List<Integer>> map : digits.entrySet()) {
            List<Integer> list = map.getValue();
            int size = list.size();
            if(size >= 2) {
                maxSum = Math.max(maxSum, list.get(size - 1) + list.get(size - 2));
            }
        }

        return maxSum;

    }
    

    private HashMap<Integer, List<Integer>> getLargestDigits(int[] nums) {
        int n = nums.length;
        HashMap<Integer, List<Integer>> digits = new HashMap<>();

        for(int i = 0; i < n; i++) {

            int lD = -1, num = nums[i];

            while(num > 0) {
                int d = num % 10;
                num /= 10;

                lD = Math.max(d, lD);
            }

            List<Integer> list = digits.getOrDefault(lD, new ArrayList<>());
            list.add(nums[i]);
            digits.put(lD, list);
        }

        return digits;
    }
}