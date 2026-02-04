class Solution {
    class Node {
        char c;
        int i;

        Node(char c, int i) {
            this.c = c;
            this.i = i;
        }
    }
    public boolean canTransform(String start, String result) {
        int n = start.length();

        List<Node> st = new ArrayList<>();
        List<Node> re = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            char s = start.charAt(i);
            char r = result.charAt(i);

            if(s != 'X') {
                st.add(new Node(s, i));
            }

            if(r != 'X') {
                re.add(new Node(r, i));
            }
        }

        if(re.size() != st.size()) return false;

        for(int i = 0; i < st.size(); i++) {
            Node s = st.get(i);
            Node r = re.get(i);

            if(s.c != r.c) return false;

            if(s.c == 'L' && s.i < r.i) return false;

            if(s.c == 'R' && s.i > r.i) return false;
        }

        return true;
    }
}