class Solution {
    public int[] finalPrices(int[] prices) {
        
        int n = prices.length;
        int answer[] = new int[n];
        
        answer[n - 1] = prices[n - 1];
        
        for(int i = 0; i < n - 1; i++) {
            int min = prices[i];
            boolean flag = false;
            
            for(int j = i + 1; j < n; j++) {
                if(prices[j] <= min) {
                    min = prices[j];
                    flag = true;
                    break;
                }
            }
            
            answer[i] = flag ? prices[i] - min : prices[i];
        }
        
        return answer;
    }
}