class RLEIterator {
    int[] encoding;
    int index;
    int length;

    public RLEIterator(int[] encoding) {
        this.index = 0;
        this.encoding = encoding;
        this.length = encoding.length;
    }
    
    public int next(int n) {

        while(index < length && encoding[index] < n) {
            n -= encoding[index];
            encoding[index] = 0;
            index += 2;
        }    

        if(index >= length) return -1;

        encoding[index] -= n;
        return encoding[index + 1];
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */