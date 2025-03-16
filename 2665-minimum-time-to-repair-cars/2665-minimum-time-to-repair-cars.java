class Solution {
    private boolean checkCars(int[] ranks, int cars, long time) {
        long count = 0;
        for(int r : ranks) {
            long c = time / r;
            long c1 = (long)Math.floor(Math.sqrt(c));

            count += c1;

            // count += Math.sqrt((time * 1.0) / r);
        }

        return count >= (long)cars;
    }

    public long repairCars(int[] ranks, int cars) {
        long max = (long)Arrays.stream(ranks).max().getAsInt();
        long l = 1, r = max * cars * cars, ans = 1;

        while(l <= r) {
            long mid = (l + r) / 2;

            if(checkCars(ranks, cars, mid)) {
                r = mid - 1;
                ans = mid;
            } else {
                l = mid + 1;
            }
        }

        return ans;

    }
}