// Last updated: 1/19/2026, 10:46:03 PM
class Solution {
    public int secondHighest(String s) {
        // Store which digits appear
        boolean[] digits = new boolean[10];
        
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                digits[c - '0'] = true;
            }
        }
        
        int count = 0;  // to track how many largest digits we’ve found
        for (int i = 9; i >= 0; i--) {
            if (digits[i]) {
                count++;
                if (count == 2) {
                    return i; // second largest found
                }
            }
        }
        
        return -1; // if second largest doesn’t exist
    }
}
