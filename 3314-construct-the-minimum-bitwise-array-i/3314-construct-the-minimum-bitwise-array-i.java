class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        Arrays.fill(ans, -1);

        for(int i = 0; i < n; i++) {
            int num = nums.get(i);
            for(int j = 1; j <= num; j++) {
                if((j | (j + 1)) == num) {
                    ans[i] = j;
                    break;
                }
            }
        }

        return ans;
    }
}