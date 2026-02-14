// Last updated: 2/14/2026, 11:55:04 PM
1class Solution {
2    public double champagneTower(int poured, int query_row, int query_glass) {
3        double[][] dp = new double[101][101]; // safer size
4        
5        dp[0][0] = poured;
6        
7        for (int i = 0; i < query_row; i++) {   // strictly <
8            for (int j = 0; j <= i; j++) {
9                
10                if (dp[i][j] > 1) {
11                    double overflow = (dp[i][j] - 1) / 2.0;
12                    
13                    dp[i+1][j] += overflow;
14                    dp[i+1][j+1] += overflow;
15                    
16                    dp[i][j] = 1;  // cap it
17                }
18            }
19        }
20        
21        return Math.min(1, dp[query_row][query_glass]);
22    }
23}