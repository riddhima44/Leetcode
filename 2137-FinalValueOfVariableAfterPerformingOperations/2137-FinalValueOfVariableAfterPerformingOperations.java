// Last updated: 1/19/2026, 10:45:52 PM
class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int X = 0;
        for (String op : operations) {
            if (op.contains("+")) X++;
            else X--;
        }
        return X;
    }
}
