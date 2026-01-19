// Last updated: 1/19/2026, 10:45:29 PM
class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int MOD = 1_000_000_007;
        long[] dp = new long[n + 1];

        dp[1] = 1;
        long share = 0;

        for (int day = 2; day <= n; day++) {

            // people who can start sharing today
            if (day - delay >= 1) {
                share = (share + dp[day - delay]) % MOD;
            }

            // people who forget today
            if (day - forget >= 1) {
                share = (share - dp[day - forget] + MOD) % MOD;
            }

            dp[day] = share;
        }

        long result = 0;
        for (int i = Math.max(1, n - forget + 1); i <= n; i++) {
            result = (result + dp[i]) % MOD;
        }

        return (int) result;
    }
}
