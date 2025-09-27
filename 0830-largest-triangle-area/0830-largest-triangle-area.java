class Solution {
    public double largestTriangleArea(int[][] points) {
        double maxArea = 0.0d;
        int n = points.length;

        for(int i = 0; i < n; i++) {
            int x1 = points[i][0], y1 = points[i][1];

            for(int j = i + 1; j < n; j++) {
                int x2 = points[j][0], y2 = points[j][1];

                for(int k = j + 1; k < n; k++) {
                    int x3 = points[k][0], y3 = points[k][1];

                    double area = 0.5 * Math.abs((x1 * (y2 - y3)) +
                        (x2 * (y3 - y1)) +
                        (x3 * (y1 - y2)));

                    maxArea = Math.max(area, maxArea);
                }
            }
        }

        return maxArea;
    }
}