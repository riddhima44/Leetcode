// Last updated: 1/24/2026, 12:14:01 AM
1class Solution {
2    public int minScoreTriangulation(int[] values) {
3        int n = values.length;
4        int[][] dp = new int[n][n];
5
6        for (int len = 2; len < n; len++) {
7            for (int i = 0; i + len < n; i++) {
8                int j = i + len;
9                dp[i][j] = Integer.MAX_VALUE;
10
11                for (int k = i + 1; k < j; k++) {
12                    int cost = dp[i][k]
13                             + dp[k][j]
14                             + values[i] * values[k] * values[j];
15                    dp[i][j] = Math.min(dp[i][j], cost);
16                }
17            }
18        }
19        return dp[0][n - 1];
20    }
21}
22