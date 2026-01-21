// Last updated: 1/21/2026, 10:09:35 PM
1class Spreadsheet {
2
3    private int[][] sheet;
4    private int rows;
5
6    public Spreadsheet(int rows) {
7        this.rows = rows;
8        sheet = new int[rows][26];
9    }
10
11    public void setCell(String cell, int value) {
12        int col = cell.charAt(0) - 'A';
13        int row = Integer.parseInt(cell.substring(1)) - 1;
14        sheet[row][col] = value;
15    }
16
17    public void resetCell(String cell) {
18        int col = cell.charAt(0) - 'A';
19        int row = Integer.parseInt(cell.substring(1)) - 1;
20        sheet[row][col] = 0;
21    }
22
23    public int getValue(String formula) {
24        // formula is always "=X+Y"
25        String expr = formula.substring(1);
26        String[] parts = expr.split("\\+");
27
28        return getOperandValue(parts[0]) + getOperandValue(parts[1]);
29    }
30
31    private int getOperandValue(String op) {
32        if (Character.isLetter(op.charAt(0))) {
33            int col = op.charAt(0) - 'A';
34            int row = Integer.parseInt(op.substring(1)) - 1;
35            return sheet[row][col];
36        } else {
37            return Integer.parseInt(op);
38        }
39    }
40}
41
42
43/**
44 * Your Spreadsheet object will be instantiated and called as such:
45 * Spreadsheet obj = new Spreadsheet(rows);
46 * obj.setCell(cell,value);
47 * obj.resetCell(cell);
48 * int param_3 = obj.getValue(formula);
49 */