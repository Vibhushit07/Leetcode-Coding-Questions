class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int maxArea = 0;

        int[] hist = new int[n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == '1') {
                    hist[j]++;
                } else {
                    hist[j] = 0;
                }
            }

            maxArea = Math.max(maxArea, getArea(hist, n));
        }

        return maxArea;
    }

    private int getArea(int[] hist, int n) {
        int[] left = new int[n];
        int[] right = new int[n];

        int maxArea = 0;

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && hist[st.peek()] >= hist[i]) {
                st.pop();
            }

            if(!st.isEmpty()) {
                left[i] = st.peek() + 1;
            } else {
                left[i] = 0;
            }

            st.push(i);
        }

        st = new Stack<>();

        for(int i = n - 1; i >= 0; i--) {
            while(!st.isEmpty() && hist[st.peek()] >= hist[i]) {
                st.pop();
            }

            if(!st.isEmpty()) {
                right[i] = st.peek() - 1;
            } else {
                right[i] = n - 1;
            }

            st.push(i);
        }

        for(int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, (right[i] - left[i] + 1) * hist[i]);
        }

        return maxArea;
    }
}