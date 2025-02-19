class Solution {
    public String getHappyString(int n, int k) {
        Queue<String> q = new LinkedList<>();
        int count = 0;
        q.add("a");
        q.add("b");
        q.add("c");

        while(!q.isEmpty()) {
            String curr = q.poll();

            if(curr.length() == n) {
                if(++count == k)
                    return curr;
                continue;
            }

            char lastChar = curr.charAt(curr.length() - 1);

            if(lastChar == 'a') {
                q.add(curr + 'b');
                q.add(curr + 'c');
            } else if (lastChar == 'b') {
                q.add(curr + 'a');
                q.add(curr + 'c');
            } else {
                q.add(curr + 'a');
                q.add(curr + 'b');
            }
        }

        return "";
    }
}