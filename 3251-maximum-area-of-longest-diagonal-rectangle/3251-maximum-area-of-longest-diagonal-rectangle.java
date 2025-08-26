class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxArea = 0;
        double longestDiagonal = 0.0;

        for(int i = 0; i < dimensions.length; i++) {
            int len = dimensions[i][0];
            int wid = dimensions[i][1];

            double diagonal = Math.sqrt(len * len + wid * wid);
            int area = len * wid;

            if(diagonal > longestDiagonal || (diagonal == longestDiagonal && area > maxArea)) {
                longestDiagonal = diagonal;
                maxArea = area;
            }
        }

        return maxArea;
    }
}