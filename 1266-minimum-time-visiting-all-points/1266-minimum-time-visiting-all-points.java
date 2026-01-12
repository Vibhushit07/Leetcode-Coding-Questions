class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int totalTime = 0;

        for(int i = 1; i < points.length; i++) {
            int dX = Math.abs(points[i][0] - points[i - 1][0]);
            int dY = Math.abs(points[i][1] - points[i - 1][1]);
            totalTime += Math.max(dX, dY);
        }

        return totalTime;
    }
}