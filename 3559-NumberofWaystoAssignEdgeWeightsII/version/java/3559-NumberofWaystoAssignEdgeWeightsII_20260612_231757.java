// Last updated: 6/12/2026, 11:17:57 PM
1class Solution {
2    static final long MOD = 1_000_000_007L;
3
4    int LOG;
5    int[][] up;
6    int[] depth;
7    long[] pow2;
8    List<Integer>[] graph;
9
10    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
11        int n = edges.length + 1;
12
13        graph = new ArrayList[n + 1];
14        for (int i = 1; i <= n; i++) {
15            graph[i] = new ArrayList<>();
16        }
17
18        for (int[] e : edges) {
19            int u = e[0], v = e[1];
20            graph[u].add(v);
21            graph[v].add(u);
22        }
23
24        LOG = 1;
25        while ((1 << LOG) <= n) LOG++;
26
27        up = new int[n + 1][LOG];
28        depth = new int[n + 1];
29
30        dfs(1, 1);
31
32        for (int j = 1; j < LOG; j++) {
33            for (int i = 1; i <= n; i++) {
34                up[i][j] = up[up[i][j - 1]][j - 1];
35            }
36        }
37
38        pow2 = new long[n + 1];
39        pow2[0] = 1;
40        for (int i = 1; i <= n; i++) {
41            pow2[i] = (pow2[i - 1] * 2) % MOD;
42        }
43
44        int m = queries.length;
45        int[] ans = new int[m];
46
47        for (int i = 0; i < m; i++) {
48            int u = queries[i][0];
49            int v = queries[i][1];
50
51            int lca = lca(u, v);
52
53            int len = depth[u] + depth[v] - 2 * depth[lca];
54
55            if (len == 0) {
56                ans[i] = 0;
57            } else {
58                ans[i] = (int) pow2[len - 1];
59            }
60        }
61
62        return ans;
63    }
64
65    private void dfs(int node, int parent) {
66        up[node][0] = parent;
67
68        for (int nxt : graph[node]) {
69            if (nxt == parent) continue;
70
71            depth[nxt] = depth[node] + 1;
72            dfs(nxt, node);
73        }
74    }
75
76    private int lca(int a, int b) {
77        if (depth[a] < depth[b]) {
78            int temp = a;
79            a = b;
80            b = temp;
81        }
82
83        int diff = depth[a] - depth[b];
84
85        for (int j = LOG - 1; j >= 0; j--) {
86            if (((diff >> j) & 1) == 1) {
87                a = up[a][j];
88            }
89        }
90
91        if (a == b) return a;
92
93        for (int j = LOG - 1; j >= 0; j--) {
94            if (up[a][j] != up[b][j]) {
95                a = up[a][j];
96                b = up[b][j];
97            }
98        }
99
100        return up[a][0];
101    }
102}