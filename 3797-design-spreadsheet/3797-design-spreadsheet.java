class Spreadsheet {

    int sheet[][];

    public Spreadsheet(int rows) {
        sheet = new int[rows][26];
    }
    
    public void setCell(String cell, int value) {
        int col = getCol(cell, 0);
        int row = getRow(cell, 1);

        sheet[row][col] = value;
    }
    
    public void resetCell(String cell) {
        int col = getCol(cell, 0);
        int row = getRow(cell, 1);

        sheet[row][col] = 0;
    }
    
    public int getValue(String formula) {
        int ind = formula.indexOf('+');

        String left = formula.substring(1, ind);
        String right = formula.substring(ind + 1);

        int leftValue = Character.isLetter(left.charAt(0)) ?
            sheet[getRow(left, 1)][getCol(left, 0)] :
            Integer.parseInt(left);

        int rightValue = Character.isLetter(right.charAt(0)) ?
            sheet[getRow(right, 1)][getCol(right, 0)] :
            Integer.parseInt(right);

        return leftValue + rightValue;
    }

    int getRow(String cell, int ind) {
        return Integer.parseInt(cell.substring(ind)) - 1;
    }

    int getCol(String cell, int ind) {
        return cell.charAt(ind) - 'A';
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */