class Solution {

    String ans = "";

    public String findDifferentBinaryString(String[] nums) {
        HashSet<String> hs = new HashSet<>();

        for(String num : nums) {
            hs.add(num);
        }

        binaryString(hs, "", nums.length);
        
        return ans;
    }

    private Boolean binaryString(HashSet<String> hs, String curr, int n) {
        if(curr.length() == n && !hs.contains(curr)) {
            ans = curr;
            return true;
        }

        if(curr.length() > n)
            return false;

        if(binaryString(hs, curr + '0', n) || binaryString(hs, curr + '1', n)) 
            return true;

        return false;
    }
}