class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer, Integer> ballColor = new HashMap<>();
        HashMap<Integer, Integer> uniqueColor = new HashMap<>();
        int []distinctColor = new int[queries.length];

        for(int i = 0; i < queries.length; i++) {
            int x = queries[i][0];
            int y = queries[i][1];

            if(ballColor.containsKey(x)) {
                int color = ballColor.get(x);
                int count = uniqueColor.get(color);

                if(count == 1) {
                    uniqueColor.remove(color);
                } else {
                    uniqueColor.put(color, count - 1);
                }
            }

            ballColor.put(x, y);
            uniqueColor.put(y, uniqueColor.getOrDefault(y, 0) + 1);

            distinctColor[i] = uniqueColor.size();
        }

        return distinctColor;

    }
}