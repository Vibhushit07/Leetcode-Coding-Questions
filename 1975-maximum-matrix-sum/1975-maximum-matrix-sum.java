class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int min = Integer.MAX_VALUE, count = 0;

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                int num = matrix[i][j];

                sum += Math.abs(num);

                if(num < 0) {
                    count++;
                }

                min = Math.min(min, Math.abs(num));
            }
        }

        return count % 2 == 0 ? sum : sum - (2L * min);
    }
}