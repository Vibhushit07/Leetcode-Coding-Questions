class Solution {

    public String findDifferentBinaryString(String[] nums) {
        HashSet<String> hs = new HashSet<>();

        for(String num : nums) {
            hs.add(num);
        }

        return binaryString(hs, "", nums.length);
    }

    private String binaryString(HashSet<String> hs, String curr, int n) {
        if(curr.length() == n && !hs.contains(curr)) {
            return curr;
        }

        if(curr.length() > n)
            return null;

        String binary = binaryString(hs, curr + '0', n);

        if(binary != null) {
            return binary;
        }

        binary = binaryString(hs, curr + '1', n);

        if(binary != null) {
            return binary;
        }

        return null;
    }
}