class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        return calculateeXOR(nums1, nums2.length) ^ calculateeXOR(nums2, nums1.length);
    }

    private int calculateeXOR(int num[], int len) {
        if (len % 2 == 0)
            return 0;
        int xor = 0;
        for (int n : num) {
            xor ^= n;
        }
        return xor;
    }
}