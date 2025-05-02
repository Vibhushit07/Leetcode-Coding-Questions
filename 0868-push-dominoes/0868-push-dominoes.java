class Solution {
    public String pushDominoes(String s) {
        String str = "L" + s + "R";
        char temp[] = str.toCharArray();
        int n = temp.length, prev = 0;

        for(int i = 1; i < n; i++) {
            if(temp[i] != '.') {
                if(temp[prev] == temp[i]) {
                    updateDominoes(temp, prev + 1, i - 1, temp[i]);
                } else if(temp[prev] == 'R' && temp[i] == 'L') {
                    int mid = (prev + i) / 2;

                    if((i - prev) % 2 == 0) {
                        updateDominoes(temp, prev + 1, mid - 1, temp[prev]);
                    } else {
                        updateDominoes(temp, prev + 1, mid, temp[prev]);
                    }
                    updateDominoes(temp, mid + 1, i - 1, temp[i]);
                }
                prev = i;
            }
        }

        return new String(temp, 1, n - 2);
    }

    private void updateDominoes(char temp[], int i, int j, char c) {
        for(int k = i; k <= j; k++) {
            temp[k] = c;
        }
    }
}