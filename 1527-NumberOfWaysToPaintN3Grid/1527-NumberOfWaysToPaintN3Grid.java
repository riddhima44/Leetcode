// Last updated: 1/19/2026, 10:46:59 PM
class Solution {
    public int numOfWays(int n) {
        long MOD = 1_000_000_007;

        long a = 6; // ABA
        long b = 6; // ABC

        for (int i = 2; i <= n; i++) {
            long newA = (a * 3 + b * 2) % MOD;
            long newB = (a * 2 + b * 2) % MOD;
            a = newA;
            b = newB;
        }

        return (int)((a + b) % MOD);
    }
}
