// Last updated: 2/13/2026, 7:17:20 PM
1import java.util.*;
2
3class Solution {
4    public static int has1(String s, int n) {
5        int cnt = 1, len = 1;
6        for (int i = 1; i < n; i++) {
7            if (s.charAt(i) == s.charAt(i - 1)) {
8                len++;
9            } else {
10                cnt = Math.max(cnt, len);
11                len = 1;
12            }
13        }
14        return Math.max(cnt, len);
15    }
16
17    static final long bias = 1L << 18;
18    static final int shift = 32;
19
20    // Pack two integers into one long key
21    static long pack(int x, int y) {
22        return ((long) (x + bias) << shift) | (long) (y + bias);
23    }
24
25    public int longestBalanced(String s) {
26        int n = s.length();
27        int ans = has1(s, n);
28
29        Map<Long, Integer> ab = new HashMap<>(n);
30        Map<Long, Integer> bc = new HashMap<>(n);
31        Map<Long, Integer> ca = new HashMap<>(n);
32        Map<Long, Integer> abc = new HashMap<>(n);
33
34        // Initial state: index -1
35        abc.put(pack(0, 0), -1);
36        ab.put(pack(0, 0), -1); // (A-B, C)
37        bc.put(pack(0, 0), -1); // (B-C, A)
38        ca.put(pack(0, 0), -1); // (C-A, B)
39
40        int[] cnt = new int[3]; // counts of 'a','b','c'
41
42        for (int i = 0; i < n; i++) {
43            cnt[s.charAt(i) - 'a']++;
44            int A = cnt[0], B = cnt[1], C = cnt[2];
45
46            // 3-letter balance: A = B = C
47            long key = pack(B - A, C - A);
48            if (abc.containsKey(key)) {
49                ans = Math.max(ans, i - abc.get(key));
50            } else {
51                abc.put(key, i);
52            }
53
54            // 2-letter balance: A = B and NO C
55            key = pack(A - B, C);
56            if (ab.containsKey(key)) {
57                ans = Math.max(ans, i - ab.get(key));
58            } else {
59                ab.put(key, i);
60            }
61
62            // 2-letter balance: B = C and NO A
63            key = pack(B - C, A);
64            if (bc.containsKey(key)) {
65                ans = Math.max(ans, i - bc.get(key));
66            } else {
67                bc.put(key, i);
68            }
69
70            // 2-letter balance: C = A and NO B
71            key = pack(C - A, B);
72            if (ca.containsKey(key)) {
73                ans = Math.max(ans, i - ca.get(key));
74            } else {
75                ca.put(key, i);
76            }
77        }
78
79        return ans;
80    }
81}