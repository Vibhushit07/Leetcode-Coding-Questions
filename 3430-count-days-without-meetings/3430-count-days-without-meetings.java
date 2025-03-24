class Solution {
    public int countDays(int days, int[][] meetings) {

        int res = 0, meeting = 0;

        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        for(int i = 1; i < meetings.length; i++) {
            if(meetings[res][1] >= meetings[i][0]) {
                meetings[res][0] = Math.min(meetings[res][0], meetings[i][0]);
                meetings[res][1] = Math.max(meetings[res][1], meetings[i][1]);
            } else {
                res++;
                meetings[res] = meetings[i];
            }
        }

        for(int i = 0; i <= res; i++) {
            meeting += meetings[i][1] - meetings[i][0] + 1;
        }

        return days - meeting;
        
    }
}