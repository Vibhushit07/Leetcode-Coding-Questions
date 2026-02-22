class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a, b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });

        int count = 0, max = -1;

        for(int[] prop : properties) {
            if(max > prop[1]) {
                count++;
            } else {
                max = Math.max(max, prop[1]);
            }
        }

        return count;
    }
}