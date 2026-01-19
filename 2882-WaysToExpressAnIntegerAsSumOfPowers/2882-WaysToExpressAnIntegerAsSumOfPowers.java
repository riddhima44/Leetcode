// Last updated: 1/19/2026, 10:45:06 PM
class Solution {
    public int numberOfWays(int n, int x) {
        final int MOD = 1_000_000_007;

        // Precompute powers
        int[] powers = new int[n + 1];
        int count = 0;
        for (int i = 1; ; i++) {
            long val = 1;
            for (int j = 0; j < x; j++) val *= i;
            if (val > n) break;
            powers[count++] = (int) val;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 0; i < count; i++) {
            int p = powers[i];
            for (int s = n; s >= p; s--) {
                dp[s] = (dp[s] + dp[s - p]) % MOD;
            }
        }

        return dp[n];
    }
}
