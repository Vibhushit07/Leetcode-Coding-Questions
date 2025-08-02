class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>();

        for(int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);

            if(i > 0) {

                int j = 1;

                while(j < i) {
                    int l = pascal.get(i - 1).get(j - 1);
                    int r = pascal.get(i - 1).get(j);
                    row.add(l + r);
                    j++;
                }

                int l = pascal.get(i - 1).get(j - 1);
                row.add(l);
            }

            pascal.add(row);

        }

        return pascal;
    }
}