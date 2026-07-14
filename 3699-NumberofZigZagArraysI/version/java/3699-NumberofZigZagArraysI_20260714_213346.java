// Last updated: 7/14/2026, 9:33:46 PM
1class Solution {
2    static final int MOD = 1_000_000_007;
3
4    public int zigZagArrays(int n, int l, int r) {
5        int m = r - l + 1;
6
7        long[] up = new long[m + 1];
8        long[] down = new long[m + 1];
9
10        // Length = 2
11        for (int last = 1; last <= m; last++) {
12            up[last] = last - 1;      // previous value < last
13            down[last] = m - last;    // previous value > last
14        }
15
16        // Build lengths 3 ... n
17        for (int len = 3; len <= n; len++) {
18
19            long[] prefixDown = new long[m + 1];
20            for (int i = 1; i <= m; i++) {
21                prefixDown[i] = (prefixDown[i - 1] + down[i]) % MOD;
22            }
23
24            long[] suffixUp = new long[m + 2];
25            for (int i = m; i >= 1; i--) {
26                suffixUp[i] = (suffixUp[i + 1] + up[i]) % MOD;
27            }
28
29            long[] newUp = new long[m + 1];
30            long[] newDown = new long[m + 1];
31
32            for (int v = 1; v <= m; v++) {
33                // previous step was down, now go up
34                newUp[v] = prefixDown[v - 1];
35
36                // previous step was up, now go down
37                newDown[v] = suffixUp[v + 1];
38            }
39
40            up = newUp;
41            down = newDown;
42        }
43
44        long ans = 0;
45
46        if (n == 2) {
47            // (Not needed by constraints, but kept for completeness)
48            for (int v = 1; v <= m; v++) {
49                ans = (ans + up[v] + down[v]) % MOD;
50            }
51        } else {
52            for (int v = 1; v <= m; v++) {
53                ans = (ans + up[v] + down[v]) % MOD;
54            }
55        }
56
57        return (int) ans;
58    }
59}