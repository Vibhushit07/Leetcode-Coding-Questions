class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        Map<Integer, Integer> freq = new HashMap<>();
        int MEX = 0;

        for(int n : nums) {
            if(n >= 0) {
                freq.put(n % value, freq.getOrDefault(n % value, 0) + 1); 
            } else {
                int num = ((n % value) + value) % value;
                freq.put(num, freq.getOrDefault(num, 0) + 1); 
            }
        }

        while(true) {
            if(freq.getOrDefault(MEX % value, 0) == 0) {
                return MEX;
            } else {
                int n = MEX % value;
                freq.put(n, freq.getOrDefault(n, 0) - 1); 
            }

            MEX++;
        }
    }
}