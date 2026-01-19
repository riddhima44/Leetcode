// Last updated: 1/19/2026, 10:48:34 PM
class Solution {

    public double soupServings(int n) {

        // Large n converges to 1
        if (n >= 5000) return 1.0;

        int m = (n + 24) / 25; // convert to units of 25
        double[][] dp = new double[m + 1][m + 1];

        for (int a = 0; a <= m; a++) {
            for (int b = 0; b <= m; b++) {

                if (a == 0 && b == 0) {
                    dp[a][b] = 0.5;
                } else if (a == 0) {
                    dp[a][b] = 1.0;
                } else if (b == 0) {
                    dp[a][b] = 0.0;
                }
            }
        }

        for (int a = 1; a <= m; a++) {
            for (int b = 1; b <= m; b++) {
                dp[a][b] =
                        0.25 * (
                                dp[Math.max(0, a - 4)][b] +
                                dp[Math.max(0, a - 3)][Math.max(0, b - 1)] +
                                dp[Math.max(0, a - 2)][Math.max(0, b - 2)] +
                                dp[Math.max(0, a - 1)][Math.max(0, b - 3)]
                        );
            }
        }

        return dp[m][m];
    }
}
