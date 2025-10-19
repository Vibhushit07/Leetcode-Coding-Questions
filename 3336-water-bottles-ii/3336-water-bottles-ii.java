class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int empty = numBottles, drink = numBottles;

        while(empty >= numExchange) {
            empty -= numExchange;
            drink++;
            empty++;
            numExchange++;
        }

        return drink;
    }
}