// Last updated: 6/11/2026, 9:49:26 PM
1class Solution {
2    static final long MOD = 1_000_000_007L;
3
4    public int assignEdgeWeights(int[][] edges) {
5        int n = edges.length + 1;
6
7        List<Integer>[] g = new ArrayList[n + 1];
8        for (int i = 1; i <= n; i++) {
9            g[i] = new ArrayList<>();
10        }
11
12        for (int[] e : edges) {
13            int u = e[0], v = e[1];
14            g[u].add(v);
15            g[v].add(u);
16        }
17
18        Queue<Integer> q = new LinkedList<>();
19        boolean[] vis = new boolean[n + 1];
20
21        q.offer(1);
22        vis[1] = true;
23
24        int depth = -1;
25
26        while (!q.isEmpty()) {
27            int sz = q.size();
28            depth++;
29
30            while (sz-- > 0) {
31                int node = q.poll();
32
33                for (int nei : g[node]) {
34                    if (!vis[nei]) {
35                        vis[nei] = true;
36                        q.offer(nei);
37                    }
38                }
39            }
40        }
41
42        return (int) modPow(2, depth - 1);
43    }
44
45    private long modPow(long a, long b) {
46        long res = 1;
47
48        while (b > 0) {
49            if ((b & 1) == 1)
50                res = (res * a) % MOD;
51
52            a = (a * a) % MOD;
53            b >>= 1;
54        }
55
56        return res;
57    }
58}