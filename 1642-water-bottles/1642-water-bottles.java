class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int n = numBottles, totalBottles = 0, emptyBottles = 0;

        while((n + emptyBottles) >= numExchange) {
            totalBottles += n;
            emptyBottles += (n % numExchange);
            n /= numExchange;

            if(emptyBottles >= numExchange) {
                n += (emptyBottles / numExchange);
                emptyBottles %= numExchange;
            }
        }

        totalBottles += n;

        return totalBottles;
    }
}