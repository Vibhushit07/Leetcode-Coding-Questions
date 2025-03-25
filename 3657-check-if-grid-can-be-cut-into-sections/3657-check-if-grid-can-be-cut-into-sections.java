class Solution {

    private List<int[]> mergeIntervals(int[][] r, boolean isVertical) {
        List<int[]> intervals = new ArrayList<>();
        List<int[]> merged = new ArrayList<>();
        for (int i = 0; i < r.length; i++) {
            intervals.add(
                    isVertical ? new int[] { r[i][0], r[i][2] } : new int[] { r[i][1], r[i][3] });
        }

        intervals.sort(Comparator.comparingInt(a -> a[0]));

        int curr[] = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            int[] c = intervals.get(i);

            if (c[0] < curr[1]) {
                curr[1] = Math.max(curr[1], c[1]);
            } else {
                merged.add(curr);
                curr = c;
            }
        }
        merged.add(curr);
        return merged;
    }

    public boolean checkValidCuts(int n, int[][] rectangles) {
        List<int[]> merged = mergeIntervals(rectangles, true);
        if (merged.size() >= 3) {
            return true;
        }

        merged = mergeIntervals(rectangles, false);
        if (merged.size() >= 3) {
            return true;
        }

        return false;
    }
}