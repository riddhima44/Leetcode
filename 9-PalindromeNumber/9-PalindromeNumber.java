// Last updated: 1/19/2026, 10:50:40 PM

class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers or ending with 0 (except 0 itself) can't be palindrome
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int rev = 0;

        // reverse half the number
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }

        // For odd length numbers, remove middle digit from rev
        return x == rev || x == rev / 10;
    }
}
