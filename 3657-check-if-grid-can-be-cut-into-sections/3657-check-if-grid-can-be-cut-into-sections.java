class Solution {
    List<int[]> buildAndMergeOpen(int[][] rectangles, boolean vertical) {
        List<int[]> intervals = new ArrayList<>();
        for (int[] rect : rectangles) {
            intervals.add(vertical ? new int[]{rect[0], rect[2]} : new int[]{rect[1], rect[3]});
        }
        
        intervals.sort(Comparator.comparingInt(a -> a[0]));
        
        List<int[]> merged = new ArrayList<>();
        int[] current = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            int[] next = intervals.get(i);
            if (current[1] > next[0]) {
                current[1] = Math.max(current[1], next[1]);
            } else {
                merged.add(current);
                current = next;
            }
        }
        
        merged.add(current);
        return merged;
    }
    
    public boolean checkValidCuts(int n, int[][] rectangles) {
       List<int[]> mergedX = buildAndMergeOpen(rectangles, true);
        if (mergedX.size() >= 3) {
            return true;
        }
        
        List<int[]> mergedY = buildAndMergeOpen(rectangles, false);
        if (mergedY.size() >= 3) {
            return true;
        }
        
        return false;
    }
}