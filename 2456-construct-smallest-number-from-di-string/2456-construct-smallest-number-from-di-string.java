class Solution {
    public String smallestNumber(String pattern) {
        String res = "";
        Stack<Integer> st = new Stack<>();

        for(int i = 1; i <= pattern.length() + 1; i++) {
            st.push(i);

            if(i == pattern.length() + 1 || pattern.charAt(i - 1) == 'I') {
                while(!st.isEmpty()) {
                    res += String.valueOf(st.pop());
                }
            } 
        }

        return res;
    }
}