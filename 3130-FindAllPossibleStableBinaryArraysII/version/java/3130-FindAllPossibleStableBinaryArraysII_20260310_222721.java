// Last updated: 3/10/2026, 10:27:21 PM
1class Solution {
2    public int numberOfStableArrays(int zero, int one, int limit) {
3        final int MOD = 1_000_000_007;
4        
5        // dp[i][j][k] = # stable arrays with i zeros, j ones, ending in k
6        // k=0 means ends in 0, k=1 means ends in 1
7        long[][][] dp = new long[zero + 1][one + 1][2];
8        
9        // Base cases: arrays of all 0s or all 1s (length <= limit)
10        for (int i = 1; i <= Math.min(limit, zero); i++) {
11            dp[i][0][0] = 1;
12        }
13        for (int j = 1; j <= Math.min(limit, one); j++) {
14            dp[0][j][1] = 1;
15        }
16        
17        for (int i = 1; i <= zero; i++) {
18            for (int j = 1; j <= one; j++) {
19                // Place a 0 at the end
20                dp[i][j][0] = (dp[i-1][j][0] + dp[i-1][j][1]) % MOD;
21                // Subtract invalid: (limit+1) consecutive 0s
22                if (i > limit) {
23                    dp[i][j][0] = (dp[i][j][0] - dp[i-limit-1][j][1] + MOD) % MOD;
24                }
25                
26                // Place a 1 at the end
27                dp[i][j][1] = (dp[i][j-1][0] + dp[i][j-1][1]) % MOD;
28                // Subtract invalid: (limit+1) consecutive 1s
29                if (j > limit) {
30                    dp[i][j][1] = (dp[i][j][1] - dp[i][j-limit-1][0] + MOD) % MOD;
31                }
32            }
33        }
34        
35        return (int) ((dp[zero][one][0] + dp[zero][one][1]) % MOD);
36    }
37}