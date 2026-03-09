// Last updated: 3/9/2026, 1:50:02 PM
1class Solution {
2    static final int MOD = 1000000007;
3
4    public int numberOfStableArrays(int zero, int one, int limit) {
5
6        long[][][][] dp = new long[zero + 1][one + 1][2][limit + 1];
7
8        if (zero > 0)
9            dp[1][0][0][1] = 1;
10
11        if (one > 0)
12            dp[0][1][1][1] = 1;
13
14        for (int z = 0; z <= zero; z++) {
15            for (int o = 0; o <= one; o++) {
16
17                for (int last = 0; last < 2; last++) {
18
19                    for (int len = 1; len <= limit; len++) {
20
21                        long ways = dp[z][o][last][len];
22                        if (ways == 0) continue;
23
24                        if (last == 0) {
25
26                            if (z + 1 <= zero && len < limit)
27                                dp[z + 1][o][0][len + 1] =
28                                    (dp[z + 1][o][0][len + 1] + ways) % MOD;
29
30                            if (o + 1 <= one)
31                                dp[z][o + 1][1][1] =
32                                    (dp[z][o + 1][1][1] + ways) % MOD;
33
34                        } else {
35
36                            if (o + 1 <= one && len < limit)
37                                dp[z][o + 1][1][len + 1] =
38                                    (dp[z][o + 1][1][len + 1] + ways) % MOD;
39
40                            if (z + 1 <= zero)
41                                dp[z + 1][o][0][1] =
42                                    (dp[z + 1][o][0][1] + ways) % MOD;
43                        }
44                    }
45                }
46            }
47        }
48
49        long ans = 0;
50
51        for (int len = 1; len <= limit; len++) {
52            ans = (ans + dp[zero][one][0][len]) % MOD;
53            ans = (ans + dp[zero][one][1][len]) % MOD;
54        }
55
56        return (int) ans;
57    }
58}