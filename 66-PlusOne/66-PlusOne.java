// Last updated: 1/19/2026, 10:50:00 PM
class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Traverse from the last digit backwards
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;  // Simple case: no carry
                return digits;
            }
            digits[i] = 0; // 9 becomes 0, carry continues
        }

        // If we reach here, all digits were 9
        int[] res = new int[n + 1];
        res[0] = 1;   // Example: 999 + 1 = 1000
        return res;
    }
}
