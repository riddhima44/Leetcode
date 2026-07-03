// Last updated: 7/3/2026, 11:08:55 PM
1import java.util.*;
2
3class Solution {
4
5    static class Edge {
6        int to;
7        int cost;
8
9        Edge(int to, int cost) {
10            this.to = to;
11            this.cost = cost;
12        }
13    }
14
15    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
16        int n = online.length;
17
18        List<Edge>[] graph = new ArrayList[n];
19        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
20
21        int[] indegree = new int[n];
22        int maxCost = 0;
23
24        for (int[] e : edges) {
25            graph[e[0]].add(new Edge(e[1], e[2]));
26            indegree[e[1]]++;
27            maxCost = Math.max(maxCost, e[2]);
28        }
29
30        // Topological Sort
31        int[] topo = new int[n];
32        Queue<Integer> q = new ArrayDeque<>();
33
34        for (int i = 0; i < n; i++) {
35            if (indegree[i] == 0) q.offer(i);
36        }
37
38        int idx = 0;
39        while (!q.isEmpty()) {
40            int u = q.poll();
41            topo[idx++] = u;
42
43            for (Edge e : graph[u]) {
44                if (--indegree[e.to] == 0) {
45                    q.offer(e.to);
46                }
47            }
48        }
49
50        int lo = 0, hi = maxCost;
51        int ans = -1;
52
53        while (lo <= hi) {
54            int mid = lo + (hi - lo) / 2;
55
56            if (can(mid, graph, topo, online, k)) {
57                ans = mid;
58                lo = mid + 1;
59            } else {
60                hi = mid - 1;
61            }
62        }
63
64        return ans;
65    }
66
67    private boolean can(int limit, List<Edge>[] graph, int[] topo,
68                        boolean[] online, long k) {
69
70        int n = graph.length;
71        long INF = Long.MAX_VALUE / 4;
72
73        long[] dist = new long[n];
74        Arrays.fill(dist, INF);
75        dist[0] = 0;
76
77        for (int u : topo) {
78
79            if (u != 0 && u != n - 1 && !online[u]) continue;
80            if (dist[u] == INF) continue;
81
82            for (Edge e : graph[u]) {
83
84                if (e.cost < limit) continue;
85
86                int v = e.to;
87                if (v != 0 && v != n - 1 && !online[v]) continue;
88
89                long nd = dist[u] + e.cost;
90                if (nd < dist[v]) {
91                    dist[v] = nd;
92                }
93            }
94        }
95
96        return dist[n - 1] <= k;
97    }
98}