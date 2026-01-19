// Last updated: 1/19/2026, 10:45:20 PM

class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int MOD = 1_000_000_007;

        int[][][] dp = new int[m][n][k];

        // First cell
        dp[0][0][grid[0][0] % k] = 1;

        // Fill DP table
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                int val = grid[i][j] % k;

                for (int r = 0; r < k; r++) {

                    // From top
                    if (i > 0) {
                        int newR = (r + val) % k;
                        dp[i][j][newR] = (dp[i][j][newR] + dp[i-1][j][r]) % MOD;
                    }

                    // From left
                    if (j > 0) {
                        int newR = (r + val) % k;
                        dp[i][j][newR] = (dp[i][j][newR] + dp[i][j-1][r]) % MOD;
                    }
                }
            }
        }

        return dp[m-1][n-1][0];
    }
}
