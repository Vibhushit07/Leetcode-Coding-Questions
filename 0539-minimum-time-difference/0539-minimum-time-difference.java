class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();

        int[] minutes = new int[n];

        for(int i = 0; i < n; i++) {
            String[] time = timePoints.get(i).split(":");
            minutes[i] = 60 * Integer.parseInt(time[0]) + Integer.parseInt(time[1]);
        }

        Arrays.sort(minutes);

        int minMinute = Integer.MAX_VALUE;

        for(int i = 1; i < n; i++) {
            minMinute = Math.min(minMinute, minutes[i] - minutes[i - 1]);
        }

        return Math.min(minMinute,
            24 * 60 - minutes[n - 1] + minutes[0]);
    }
}