class Solution {
    public String decodeString(String s) {
        String res = "";

        Stack<String> st = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c == ']') {
                String str = "", str1 = "";
                while(!st.peek().equals("[")) {
                    str = st.pop() + str;
                }

                st.pop();
                String n = "";
                while(!st.isEmpty() && isNum(st.peek())) {
                    n = st.pop() + n;
                }
                int num = Integer.parseInt(n);

                System.out.println("str b: " + str);
                System.out.println("num " + num);

                for(int j = 0; j < num; j++) {
                    str1 += str;
                }

                System.out.println("str a: " + str);

                if(st.isEmpty()) {
                    res += str1;
                } else {
                    st.push(str1);
                }

                System.out.println("res " + res);

            } else {
                st.push(c + "");
            }
        }

        String str = "";

        while(!st.isEmpty()) {
            str = st.pop() + str;
        }

        return res + str;
    }

    private boolean isNum(String s) {
        char c = s.charAt(0);

        return c >= '0' && c <= '9';
    }
}