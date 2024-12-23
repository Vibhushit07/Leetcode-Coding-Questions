class Solution {
    public int maxProfit(int[] prices) {

        int price = prices[0], profit = 0;
        
        for(int i = 1; i < prices.length; i++) {
            price = Math.min(price, prices[i]);
            profit = Math.max(profit, prices[i] - price);
        }
        
        return profit;
    }
}