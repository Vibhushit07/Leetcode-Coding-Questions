class Solution {
    public int punishmentNumber(int n) {
        int sum = 0;

        for(int i = 1; i <= n; i++) {
            int square = i * i;

            if(validPartition(square, i)) {
                sum += square;
            }
        }

        return sum;
    }

    private boolean validPartition(int num, int target) {
        if(num < target || target < 0)
            return false;
        if(num == target)
            return true;

        return validPartition(num / 10, target - (num % 10)) ||
            validPartition(num / 100, target - (num % 100)) ||
            validPartition(num / 1000, target - (num % 1000));
    }
}