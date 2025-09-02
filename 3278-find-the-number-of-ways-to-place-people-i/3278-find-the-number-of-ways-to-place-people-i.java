class Solution {

    boolean checkValid(int[][] points, int i, int j, int n) {
        int x1 = points[i][0], x2 = points[j][0];
        int y1 = points[i][1], y2 = points[j][1];

        for(int k = 0; k < n; k++) {
            if(k != i && k != j) {
                int x = points[k][0], y = points[k][1];
                if(x >= x1 && x <= x2 && y <= y1 && y >= y2) 
                    return false;
            }
        }

        return true;
    }
 
    public int numberOfPairs(int[][] points) {
        int n = points.length, count = 0;

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int x1 = points[i][0], x2 = points[j][0];
                int y1 = points[i][1], y2 = points[j][1];

                if(x1 <= x2 && y1 >= y2) {
                    if(checkValid(points, i, j, n)) {
                        count++;
                    }
                } else if (x1 >= x2 && y1 <= y2) {
                    if(checkValid(points, j, i, n)) {
                        count++;
                    }
                }
            }
        }
        return count;    
    }
}