// Last updated: 4/30/2026, 9:28:17 PM
1import java.util.*;
2
3class Solution {
4    public int maxPathScore(int[][] grid, int k) {
5        int m = grid.length, n = grid[0].length;
6
7        // dp[i][j][c] = max score reaching (i,j) with cost c
8        int[][][] dp = new int[m][n][k + 1];
9
10        // initialize all as unreachable
11        for (int i = 0; i < m; i++) {
12            for (int j = 0; j < n; j++) {
13                Arrays.fill(dp[i][j], -1);
14            }
15        }
16
17        // start point
18        dp[0][0][0] = 0;
19
20        for (int i = 0; i < m; i++) {
21            for (int j = 0; j < n; j++) {
22                for (int c = 0; c <= k; c++) {
23                    if (dp[i][j][c] == -1) continue;
24
25                    // move RIGHT
26                    if (j + 1 < n) {
27                        int val = grid[i][j + 1];
28                        int cost = (val == 0) ? 0 : 1;
29
30                        if (c + cost <= k) {
31                            dp[i][j + 1][c + cost] = Math.max(
32                                dp[i][j + 1][c + cost],
33                                dp[i][j][c] + val
34                            );
35                        }
36                    }
37
38                    // move DOWN
39                    if (i + 1 < m) {
40                        int val = grid[i + 1][j];
41                        int cost = (val == 0) ? 0 : 1;
42
43                        if (c + cost <= k) {
44                            dp[i + 1][j][c + cost] = Math.max(
45                                dp[i + 1][j][c + cost],
46                                dp[i][j][c] + val
47                            );
48                        }
49                    }
50                }
51            }
52        }
53
54        // find best answer at destination
55        int ans = -1;
56        for (int c = 0; c <= k; c++) {
57            ans = Math.max(ans, dp[m - 1][n - 1][c]);
58        }
59
60        return ans;
61    }
62}