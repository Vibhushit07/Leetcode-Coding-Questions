class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int l1 = str1.length(), l2 = str2.length();
        
        if(!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        
        int l = gcd(str1.length(), str2.length());
        return str1.substring(0, l);
    }
    
    private int gcd(int l1, int l2) {
        return l2 == 0 ? l1 : gcd(l2, l1 % l2);
    }
}