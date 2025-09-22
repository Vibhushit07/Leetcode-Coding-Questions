class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        int maxFreq = 0, totalFreq = 0;

        for(int num : nums) {
            freq[num]++;
        }

        for(int f : freq) {
            if(maxFreq < f) {
                maxFreq = f;
                totalFreq = f;

            } else if(maxFreq == f) {
                totalFreq += f;
            }
        }

        return totalFreq;
    }
}