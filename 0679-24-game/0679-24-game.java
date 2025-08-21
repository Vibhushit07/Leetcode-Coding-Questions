class Solution {

    final double esp = 1e-6;

    double[] getOperations(double a, double b) {
        double[] res = new double[6];

        res[0] = a + b;
        res[1] = a - b;
        res[2] = b - a;
        res[3] = a * b;

        if(b > 0.0) {
            res[4] = a / b;	
        }

        if(a > 0.0) {
            res[5] = b / a;	
        }

        return res;
    }

    boolean game24(List<Double> nums) {
        int n = nums.size();

        if (n == 1) {
            return Math.abs(nums.get(0) - 24) <= esp;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                double[] res = getOperations(nums.get(i), nums.get(j));
                List<Double> temp = new ArrayList<>();
                for (int k = 0; k < n; k++) {
                    if (k != i && k != j) {
                        temp.add(nums.get(k));
                    }
                }

                for (double r : res) {
                    temp.add(r);
                    if (game24(temp)) {
                        return true;
                    }
                    temp.remove(temp.size() - 1);
                }
            }
        }

        return false;
    }

    public boolean judgePoint24(int[] cards) {
        List<Double> nums = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            nums.add((double) cards[i]);
        }

        return game24(nums);
    }

}