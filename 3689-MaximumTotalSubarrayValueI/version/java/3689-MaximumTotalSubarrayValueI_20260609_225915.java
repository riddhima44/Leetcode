// Last updated: 6/9/2026, 10:59:15 PM
1import java.util.*;
2
3class Solution {
4
5    static class SegmentTree {
6        int n;
7        int[] tree;
8
9        SegmentTree(int n) {
10            this.n = n;
11            tree = new int[4 * n];
12        }
13
14        void update(int idx, int val) {
15            update(1, 0, n - 1, idx, val);
16        }
17
18        private void update(int node, int l, int r, int idx, int val) {
19            if (l == r) {
20                tree[node] = val;
21                return;
22            }
23
24            int mid = (l + r) >> 1;
25
26            if (idx <= mid) {
27                update(node * 2, l, mid, idx, val);
28            } else {
29                update(node * 2 + 1, mid + 1, r, idx, val);
30            }
31
32            tree[node] = Math.max(tree[node * 2], tree[node * 2 + 1]);
33        }
34
35        int query(int L, int R) {
36            if (L > R) return 0;
37            return query(1, 0, n - 1, L, R);
38        }
39
40        private int query(int node, int l, int r, int L, int R) {
41            if (L <= l && r <= R) return tree[node];
42            if (r < L || l > R) return 0;
43
44            int mid = (l + r) >> 1;
45
46            return Math.max(
47                query(node * 2, l, mid, L, R),
48                query(node * 2 + 1, mid + 1, r, L, R)
49            );
50        }
51    }
52
53    public List<Boolean> getResults(int[][] queries) {
54        int MAX = 50001; // sentinel > every possible obstacle position
55
56        TreeSet<Integer> obstacles = new TreeSet<>();
57        obstacles.add(0);
58        obstacles.add(MAX);
59
60        for (int[] q : queries) {
61            if (q[0] == 1) {
62                obstacles.add(q[1]);
63            }
64        }
65
66        SegmentTree seg = new SegmentTree(MAX + 1);
67
68        Integer prev = null;
69        for (int pos : obstacles) {
70            if (prev != null) {
71                seg.update(pos, pos - prev);
72            }
73            prev = pos;
74        }
75
76        List<Boolean> ans = new ArrayList<>();
77
78        for (int i = queries.length - 1; i >= 0; i--) {
79            int[] q = queries[i];
80
81            if (q[0] == 1) {
82                int x = q[1];
83
84                Integer left = obstacles.lower(x);
85                Integer right = obstacles.higher(x);
86
87                seg.update(right, right - left);
88                obstacles.remove(x);
89
90            } else {
91                int x = q[1];
92                int sz = q[2];
93
94                int p = obstacles.floor(x);
95
96                int bestGap = Math.max(
97                    seg.query(0, p),
98                    x - p
99                );
100
101                ans.add(bestGap >= sz);
102            }
103        }
104
105        Collections.reverse(ans);
106        return ans;
107    }
108}