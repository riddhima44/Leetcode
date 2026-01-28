// Last updated: 1/28/2026, 10:37:10 PM
1import java.util.*;
2
3class Solution {
4    public int minCost(int[][] grid, int k) {
5        int m = grid.length, n = grid[0].length;
6        long[][][] dp = new long[k + 1][m][n];
7        for (int t = 0; t <= k; t++) {
8            for (int i = 0; i < m; i++) {
9                for (int j = 0; j < n; j++) {
10                    dp[t][i][j] = Long.MAX_VALUE / 2;
11                }
12            }
13        }
14        dp[0][0][0] = 0;
15        
16        // t = 0: normal path
17        for (int i = 0; i < m; i++) {
18            for (int j = 0; j < n; j++) {
19                if (i == 0 && j == 0) continue;
20                long fromUp = (i > 0) ? dp[0][i - 1][j] : Long.MAX_VALUE / 2;
21                long fromLeft = (j > 0) ? dp[0][i][j - 1] : Long.MAX_VALUE / 2;
22                dp[0][i][j] = grid[i][j] + Math.min(fromUp, fromLeft);
23            }
24        }
25        
26        int MAXV = 10000;
27        for (int tele = 1; tele <= k; tele++) {
28            // Compute suffix min for previous tele-1
29            long[] minPerVal = new long[MAXV + 1];
30            for (int v = 0; v <= MAXV; v++) minPerVal[v] = Long.MAX_VALUE / 2;
31            for (int i = 0; i < m; i++) {
32                for (int j = 0; j < n; j++) {
33                    int v = grid[i][j];
34                    minPerVal[v] = Math.min(minPerVal[v], dp[tele - 1][i][j]);
35                }
36            }
37            for (int v = MAXV - 1; v >= 0; v--) {
38                minPerVal[v] = Math.min(minPerVal[v], minPerVal[v + 1]);
39            }
40            
41            // Teleport ins (cost 0)
42            for (int i = 0; i < m; i++) {
43                for (int j = 0; j < n; j++) {
44                    int v = grid[i][j];
45                    dp[tele][i][j] = Math.min(dp[tele][i][j], minPerVal[v]);
46                }
47            }
48            
49            // Normal moves topo fill for this tele
50            for (int i = 0; i < m; i++) {
51                for (int j = 0; j < n; j++) {
52                    if (i == 0 && j == 0) continue;
53                    long fromUp = (i > 0) ? dp[tele][i - 1][j] : Long.MAX_VALUE / 2;
54                    long fromLeft = (j > 0) ? dp[tele][i][j - 1] : Long.MAX_VALUE / 2;
55                    long normal = grid[i][j] + Math.min(fromUp, fromLeft);
56                    dp[tele][i][j] = Math.min(dp[tele][i][j], normal);
57                }
58            }
59        }
60        
61        long ans = Long.MAX_VALUE / 2;
62        for (int t = 0; t <= k; t++) {
63            ans = Math.min(ans, dp[t][m - 1][n - 1]);
64        }
65        return ans == Long.MAX_VALUE / 2 ? -1 : (int) ans;
66    }
67}