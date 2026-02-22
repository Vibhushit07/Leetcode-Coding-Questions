class Solution {
    Map<Integer, Integer> cache = new HashMap<>();

    public int getKth(int lo, int hi, int k) {
        List<int[]>  list = new ArrayList<>();

        for(int i = lo; i <= hi; i++) {
            list.add(new int[]{i, getPower(i)});
        }

        list.sort((a, b) -> {
            if(a[1] == b[1]) {
                return a[0] - b[0];
            }

            return a[1] - b[1];
        });

        return list.get(k - 1)[0];
    }

    private int getPower(int x) {
        if(x == 1) return 0;

        if(cache.containsKey(x)) return cache.get(x);
        
        int power = 1 + (x % 2 == 0 ? getPower(x / 2) : getPower(3 * x + 1));

        cache.put(x, power);

        return power;
    }
}