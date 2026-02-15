class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int m = a.length(), n = b.length();

        int i = m - 1, j = n - 1;
        int carry = 0, sum = 0;

        while(i >= 0 || j >= 0) {
            sum = carry;

            if(i >= 0) {
                sum += a.charAt(i) - '0';
            }

            if(j >= 0) {
                sum += b.charAt(j) - '0';
            }

            sb.append(sum % 2 == 0 ? '0' : '1');

            carry = sum > 1 ? 1 : 0;

            i--;
            j--;
        }

        if(carry == 1) sb.append('1');

        return sb.reverse().toString();
    }
}