// Last updated: 1/19/2026, 10:45:49 PM
class Solution {
    public int nextBeautifulNumber(int n) {
        for (int x = n + 1; ; x++) {
            if (isBalanced(x)) {
                return x;
            }
        }
    }

    private boolean isBalanced(int x) {
        int[] freq = new int[10];

        int temp = x;
        while (temp > 0) {
            int d = temp % 10;
            freq[d]++;
            temp /= 10;
        }

        for (int d = 0; d <= 9; d++) {
            if (freq[d] != 0 && freq[d] != d) {
                return false;
            }
        }
        return true;
    }
}
