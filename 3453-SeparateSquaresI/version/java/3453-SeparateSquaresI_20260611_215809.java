// Last updated: 6/11/2026, 9:58:09 PM
1class Solution {
2    public long maximumScore(int[][] grid) {
3        int n = grid.length;
4
5        if (n == 1) return 0;   // Fix for single-column grid
6
7        int H = n + 1;
8
9        long[][] pref = new long[n][n + 1];
10
11        for (int col = 0; col < n; col++) {
12            for (int r = 0; r < n; r++) {
13                pref[col][r + 1] = pref[col][r] + grid[r][col];
14            }
15        }
16
17        long[][][] gain = new long[n][H][H];
18
19        for (int col = 0; col < n; col++) {
20            for (int a = 0; a <= n; a++) {
21                for (int b = a; b <= n; b++) {
22                    gain[col][a][b] = pref[col][b] - pref[col][a];
23                }
24            }
25        }
26
27        long[][] dp = new long[H][H];
28
29        for (int h0 = 0; h0 <= n; h0++) {
30            for (int h1 = 0; h1 <= n; h1++) {
31                dp[h0][h1] = gain[0][h0][h1];
32            }
33        }
34
35        for (int col = 1; col <= n - 2; col++) {
36
37            long[][] ndp = new long[H][H];
38
39            for (int b = 0; b <= n; b++) {
40
41                long[] prefMax = new long[H + 1];
42                prefMax[0] = Long.MIN_VALUE / 4;
43
44                for (int a = 0; a <= n; a++) {
45                    prefMax[a + 1] =
46                            Math.max(prefMax[a], dp[a][b]);
47                }
48
49                long[] sufMax = new long[H + 1];
50                sufMax[n] = dp[n][b] + gain[col][b][n];
51
52                for (int a = n - 1; a >= 0; a--) {
53                    sufMax[a] = Math.max(
54                            sufMax[a + 1],
55                            dp[a][b] + gain[col][b][a]
56                    );
57                }
58
59                for (int c = 0; c <= n; c++) {
60
61                    long best = sufMax[c];
62
63                    if (prefMax[c] > Long.MIN_VALUE / 8) {
64                        best = Math.max(
65                                best,
66                                prefMax[c] + gain[col][b][c]
67                        );
68                    }
69
70                    ndp[b][c] = best;
71                }
72            }
73
74            dp = ndp;
75        }
76
77        long ans = 0;
78
79        for (int a = 0; a <= n; a++) {
80            for (int b = 0; b <= n; b++) {
81                ans = Math.max(
82                        ans,
83                        dp[a][b] + gain[n - 1][b][a]
84                );
85            }
86        }
87
88        return ans;
89    }
90}