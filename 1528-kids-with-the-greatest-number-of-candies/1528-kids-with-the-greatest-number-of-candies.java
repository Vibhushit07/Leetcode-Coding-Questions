class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = -1, n = candies.length;
        
        List<Boolean> res = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            if(max < candies[i])
                max = candies[i];
        }
        
        for(int i = 0; i < n; i++) {
            if(max <= candies[i] + extraCandies)
                res.add(true);
            else
                res.add(false);
        }
        
        return res;
    }
}