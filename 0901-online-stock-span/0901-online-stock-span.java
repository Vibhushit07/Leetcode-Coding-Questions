class StockSpanner {
    
    static Stack<int[]> stack;
    static int count;

    public StockSpanner() {
        stack = new Stack<>();
        count = 0;
    }
    
    public int next(int price) {
        if(stack.isEmpty()) {
            stack.push(new int[]{count, price});
            return 1;
        } else {
            while(!stack.isEmpty() && stack.peek()[1] <= price) {
                stack.pop();
            }
            count++;
            int span = stack.isEmpty() ? count + 1 : (count - stack.peek()[0]);
            stack.push(new int[]{count, price});
            return span;
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */