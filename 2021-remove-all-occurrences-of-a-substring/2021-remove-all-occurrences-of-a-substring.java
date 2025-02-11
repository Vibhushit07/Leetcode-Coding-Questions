class Solution {
    public String removeOccurrences(String s, String part) {
        
        Stack<Character> st = new Stack<>();
        int pLen = part.length();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == part.charAt(pLen - 1)) {
                String str = s.charAt(i) + "";
                int count = 1;
                while(!st.isEmpty() && count != pLen) {
                    str = st.pop() + str;
                    count++;
                }

                System.out.println(i + " " + str + " " + count);

                if(!str.equals(part)) {
                    for(int j = 0; j < str.length(); j++) {
                        st.push(str.charAt(j));
                    }
                } 
            } else {
                st.push(s.charAt(i));
            }
        }

        String str = "";

        while(!st.isEmpty()) {
            str = st.pop() + str;
        }

        return str;
    }
}