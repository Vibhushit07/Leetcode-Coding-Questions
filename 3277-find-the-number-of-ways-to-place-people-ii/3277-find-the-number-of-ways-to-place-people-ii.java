class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length, validPoints = 0;

        Arrays.sort(points, (a, b) -> {
            if(a[0] == b[0]) {
                return Integer.compare(b[1], a[1]);
            }

            return Integer.compare(a[0], b[0]);
        });

        for(int i = 0; i < n; i++) {
            int maxY = Integer.MIN_VALUE;
            int x1 = points[i][0], y1 = points[i][1];

            for(int j = i + 1; j < n; j++) {
                int x2 = points[j][0], y2 = points[j][1];

                if(y2 <= y1 && maxY < y2) {
                    validPoints++;
                    maxY = y2;
                }
            }
        }

        return validPoints;
    }
}