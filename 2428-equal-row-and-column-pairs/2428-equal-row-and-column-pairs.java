class Solution {

    List<Integer> row(int grid[][], int r) {
        List<Integer> list = new ArrayList<Integer>();

        for(int i = 0; i < grid.length; i++) {
            list.add(grid[r][i]);
        } 
        return list;
    }

    List<Integer> col(int grid[][], int c) {
        List<Integer> list = new ArrayList<Integer>();

        for(int i = 0; i < grid.length; i++) {
            list.add(grid[i][c]);
        }

        return list; 
    }

    public int equalPairs(int[][] grid) {
        int n = grid.length, count = 0;

        for(int i = 0; i < n; i++) {
            List<Integer> list = row(grid, i);
            for(int j = 0; j < n; j++) {
                if(list.equals(col(grid, j))) {
                    count++;
                }
            }
        }

        return count;
    }
}