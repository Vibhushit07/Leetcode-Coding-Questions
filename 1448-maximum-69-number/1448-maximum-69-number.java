class Solution {
    public int maximum69Number (int num) {
        char n[] = String.valueOf(num).toCharArray();

        for(int i = 0; i < n.length; i++) {
            if(n[i] == '6') {
                n[i] = '9';
                break;
            }
        }

        return Integer.parseInt(new String(n));
    }
}