class Solution {
    private List<Integer> sums;
    private int totalSum;

    public Solution(int[] weights) {

        sums = new ArrayList<>();
        int sum = 0;

        for(int w : weights) {
            sum += w;
            sums.add(sum);
        }

        totalSum = sum;
    }

    public int pickIndex() {
        Random random = new Random();
        int target = random.nextInt(totalSum) + 1;
        int l = 0, h = sums.size() - 1;

        while(l <= h) {
            int mid = l + (h - l) / 2;
            if(sums.get(mid) < target) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }

        return l;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */