class ProductOfNumbers {

    List<Integer> prefixProd;

    public ProductOfNumbers() {
        prefixProd = new ArrayList<>();
        prefixProd.add(1);    
    }
    
    public void add(int num) {
        if(num == 0) {
            prefixProd = new ArrayList<>();
            prefixProd.add(1); 
        } else {
            prefixProd.add(num * prefixProd.get(prefixProd.size() - 1));
        }
    }
    
    public int getProduct(int k) {
        if(k > prefixProd.size() - 1) 
            return 0;
        
        return prefixProd.get(prefixProd.size() - 1) /
            prefixProd.get(prefixProd.size() - 1 - k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */