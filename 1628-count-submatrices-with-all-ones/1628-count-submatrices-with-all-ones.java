class Solution {

    public int getSubMat(int[] ones) {
        int cons = 0, submat = 0;

        for (int i = 0; i < ones.length; i++) {
            if (ones[i] == 0) {
                cons = 0;
            } else {
                cons++;
                submat += cons;
            }
        }

        return submat;
    }

    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length, submat = 0;

        for (int i = 0; i < m; i++) {
            int ones[] = new int[n];
            Arrays.fill(ones, 1);

            for (int j = i; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    ones[k] &= mat[j][k];
                }

                submat += getSubMat(ones);
            }
        }

        return submat;
    }
}