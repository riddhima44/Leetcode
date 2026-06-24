// Last updated: 6/25/2026, 1:09:42 AM
1class Solution {
2    static final long MOD = 1_000_000_007L;
3
4    public int zigZagArrays(int n, int l, int r) {
5        int m = r - l + 1;
6
7        long[][] K = new long[m][m];
8
9        for (int i = 0; i < m; i++) {
10            for (int j = 0; j < i; j++) {
11                K[i][j] = 1;
12            }
13        }
14
15        long[][] KT = transpose(K);
16
17        long[] up2 = new long[m];
18        long[] down2 = new long[m];
19
20        for (int i = 0; i < m; i++) {
21            up2[i] = i;
22            down2[i] = m - 1 - i;
23        }
24
25        if (n == 2) {
26            long ans = 0;
27            for (long x : up2) ans = (ans + x) % MOD;
28            for (long x : down2) ans = (ans + x) % MOD;
29            return (int) ans;
30        }
31
32        long[][] B = multiply(K, KT);
33        long[][] C = multiply(KT, K);
34
35        long[] upBase, downBase;
36        long exp;
37
38        if ((n & 1) == 0) {
39            upBase = up2;
40            downBase = down2;
41            exp = (n - 2L) / 2;
42        } else {
43            upBase = multiply(K, down2);
44            downBase = multiply(KT, up2);
45            exp = (n - 3L) / 2;
46        }
47
48        long[][] BPow = power(B, exp);
49        long[][] CPow = power(C, exp);
50
51        long[] upFinal = multiply(BPow, upBase);
52        long[] downFinal = multiply(CPow, downBase);
53
54        long ans = 0;
55
56        for (long x : upFinal) ans = (ans + x) % MOD;
57        for (long x : downFinal) ans = (ans + x) % MOD;
58
59        return (int) ans;
60    }
61
62    private long[][] transpose(long[][] A) {
63        int n = A.length;
64        int m = A[0].length;
65
66        long[][] T = new long[m][n];
67
68        for (int i = 0; i < n; i++) {
69            for (int j = 0; j < m; j++) {
70                T[j][i] = A[i][j];
71            }
72        }
73
74        return T;
75    }
76
77    private long[][] multiply(long[][] A, long[][] B) {
78        int n = A.length;
79        int p = B.length;
80        int m = B[0].length;
81
82        long[][] C = new long[n][m];
83
84        for (int i = 0; i < n; i++) {
85            for (int k = 0; k < p; k++) {
86                if (A[i][k] == 0) continue;
87
88                long val = A[i][k];
89
90                for (int j = 0; j < m; j++) {
91                    C[i][j] = (C[i][j] + val * B[k][j]) % MOD;
92                }
93            }
94        }
95
96        return C;
97    }
98
99    private long[] multiply(long[][] A, long[] v) {
100        int n = A.length;
101        int m = v.length;
102
103        long[] res = new long[n];
104
105        for (int i = 0; i < n; i++) {
106            long cur = 0;
107
108            for (int j = 0; j < m; j++) {
109                cur = (cur + A[i][j] * v[j]) % MOD;
110            }
111
112            res[i] = cur;
113        }
114
115        return res;
116    }
117
118    private long[][] power(long[][] base, long exp) {
119        int n = base.length;
120
121        long[][] res = new long[n][n];
122
123        for (int i = 0; i < n; i++) {
124            res[i][i] = 1;
125        }
126
127        while (exp > 0) {
128            if ((exp & 1) == 1) {
129                res = multiply(res, base);
130            }
131
132            base = multiply(base, base);
133            exp >>= 1;
134        }
135
136        return res;
137    }
138}