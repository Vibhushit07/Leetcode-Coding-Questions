class Solution {
    public int minCost(String colors, int[] neededTime) {
        int j = 0, time = 0;

        for(int i = 1; i < colors.length(); i++) {
            if(colors.charAt(j) == colors.charAt(i)) {
                time += Math.min(neededTime[i], neededTime[j]);
                j = neededTime[i] < neededTime[j] ? j : i;
            } else {
                j = i;
            }
        }

        return time;
    }
}