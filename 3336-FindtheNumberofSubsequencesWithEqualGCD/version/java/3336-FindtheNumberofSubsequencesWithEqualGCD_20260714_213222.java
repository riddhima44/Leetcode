// Last updated: 7/14/2026, 9:32:22 PM
1class Solution {
2    private static final int MOD = 1_000_000_007;
3    private static final int MAX = 200;
4
5    public int subsequencePairCount(int[] nums) {
6        long[][] dp = new long[MAX + 1][MAX + 1];
7        dp[0][0] = 1;
8
9        for (int num : nums) {
10            long[][] next = new long[MAX + 1][MAX + 1];
11
12            for (int g1 = 0; g1 <= MAX; g1++) {
13                for (int g2 = 0; g2 <= MAX; g2++) {
14                    long ways = dp[g1][g2];
15                    if (ways == 0) continue;
16
17                    // Don't take the current element
18                    next[g1][g2] = (next[g1][g2] + ways) % MOD;
19
20                    // Put in first subsequence
21                    int ng1 = (g1 == 0) ? num : gcd(g1, num);
22                    next[ng1][g2] = (next[ng1][g2] + ways) % MOD;
23
24                    // Put in second subsequence
25                    int ng2 = (g2 == 0) ? num : gcd(g2, num);
26                    next[g1][ng2] = (next[g1][ng2] + ways) % MOD;
27                }
28            }
29
30            dp = next;
31        }
32
33        long ans = 0;
34        for (int g = 1; g <= MAX; g++) {
35            ans = (ans + dp[g][g]) % MOD;
36        }
37
38        return (int) ans;
39    }
40
41    private int gcd(int a, int b) {
42        while (b != 0) {
43            int t = a % b;
44            a = b;
45            b = t;
46        }
47        return a;
48    }
49}