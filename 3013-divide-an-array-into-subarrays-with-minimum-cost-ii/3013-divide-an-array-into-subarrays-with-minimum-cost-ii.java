class Solution {
    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;

        TreeSet<int[]> kMin = new TreeSet<>((a, b) -> {
            if(a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        TreeSet<int[]> remaining = new TreeSet<>((a, b) -> {
            if(a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        long minSum = Long.MAX_VALUE, sum = 0L;

        int i = 1;

        while(i < n && i - dist <= 0) {
            int[] pair = new int[]{nums[i], i};

            kMin.add(pair);
            sum += nums[i];

            if(kMin.size() >= k) {
                int[] largest = kMin.pollLast();
                sum -= largest[0];
                remaining.add(largest);
            }

            i++;
        }

        while(i < n) {
            int[] pair = new int[]{nums[i], i};

            kMin.add(pair);
            sum += nums[i];

            if(kMin.size() >= k) {
                int[] largest = kMin.pollLast();
                sum -= largest[0];
                remaining.add(largest);
            }

            minSum = Math.min(minSum, sum);

            int rmIdx = i - dist;
            int[] rmPair = new int[]{nums[rmIdx], rmIdx};

            if(kMin.remove(rmPair)) {
                sum -= rmPair[0];
                if (!remaining.isEmpty()) {
                    int[] promote = remaining.pollFirst();
                    kMin.add(promote);
                    sum += promote[0];
                }
            } else {
                remaining.remove(rmPair);
            }

            i++;
        }

        return nums[0] + minSum;
    }
}