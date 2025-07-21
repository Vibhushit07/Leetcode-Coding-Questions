class Solution {
    public String makeFancyString(String s) {
        char c[] = s.toCharArray();

        char last = c[0];

        int pos = 0, count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (c[i] != last) {
                last = c[i];
                count = 0;
            }

            if (++count <= 2) {
                c[pos++] = c[i];
            }
        }

        return new String(c, 0, pos);
    }
}