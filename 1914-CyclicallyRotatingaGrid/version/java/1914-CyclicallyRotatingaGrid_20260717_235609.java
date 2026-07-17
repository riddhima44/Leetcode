// Last updated: 7/17/2026, 11:56:09 PM
1import java.util.*;
2
3class Solution {
4    static final int MOD = 1_000_000_007;
5
6    public int[] sumAndMultiply(String s, int[][] queries) {
7
8        int m = s.length();
9
10        ArrayList<Integer> pos = new ArrayList<>();
11        ArrayList<Integer> digits = new ArrayList<>();
12
13        // Store positions and values of non-zero digits
14        for (int i = 0; i < m; i++) {
15            int d = s.charAt(i) - '0';
16            if (d != 0) {
17                pos.add(i);
18                digits.add(d);
19            }
20        }
21
22        int n = digits.size();
23
24        // Prefix number modulo MOD
25        long[] pref = new long[n + 1];
26
27        // Prefix digit sum
28        long[] sumPref = new long[n + 1];
29
30        for (int i = 0; i < n; i++) {
31            pref[i + 1] = (pref[i] * 10 + digits.get(i)) % MOD;
32            sumPref[i + 1] = sumPref[i] + digits.get(i);
33        }
34
35        // Powers of 10 modulo MOD
36        long[] pow10 = new long[n + 1];
37        pow10[0] = 1;
38
39        for (int i = 1; i <= n; i++) {
40            pow10[i] = (pow10[i - 1] * 10) % MOD;
41        }
42
43        int[] ans = new int[queries.length];
44
45        for (int i = 0; i < queries.length; i++) {
46
47            int l = queries[i][0];
48            int r = queries[i][1];
49
50            int left = lowerBound(pos, l);
51            int right = upperBound(pos, r) - 1;
52
53            if (left > right) {
54                ans[i] = 0;
55                continue;
56            }
57
58            int len = right - left + 1;
59
60            long x = (pref[right + 1] - (pref[left] * pow10[len]) % MOD + MOD) % MOD;
61
62            long sum = sumPref[right + 1] - sumPref[left];
63
64            ans[i] = (int) ((x * (sum % MOD)) % MOD);
65        }
66
67        return ans;
68    }
69
70    private int lowerBound(ArrayList<Integer> list, int target) {
71        int lo = 0, hi = list.size();
72
73        while (lo < hi) {
74            int mid = lo + (hi - lo) / 2;
75
76            if (list.get(mid) >= target)
77                hi = mid;
78            else
79                lo = mid + 1;
80        }
81
82        return lo;
83    }
84
85    private int upperBound(ArrayList<Integer> list, int target) {
86        int lo = 0, hi = list.size();
87
88        while (lo < hi) {
89            int mid = lo + (hi - lo) / 2;
90
91            if (list.get(mid) > target)
92                hi = mid;
93            else
94                lo = mid + 1;
95        }
96
97        return lo;
98    }
99}