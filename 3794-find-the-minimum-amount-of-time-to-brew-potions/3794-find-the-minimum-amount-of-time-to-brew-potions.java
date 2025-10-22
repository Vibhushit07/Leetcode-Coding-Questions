class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;

        long[] time = new long[n];

        for(int i = 0; i < m; i++) {
            time[0] += (skill[0] * mana[i]);

            for(int j = 1; j < n; j++) {
                time[j] = Math.max(time[j], time[j - 1]) + (skill[j] * mana[i]);
            }

            for(int j = n - 1; j > 0; j--) {
                time[j - 1] = time[j] - (skill[j] * mana[i]);
            }
        }

        return time[n - 1];
    }
}