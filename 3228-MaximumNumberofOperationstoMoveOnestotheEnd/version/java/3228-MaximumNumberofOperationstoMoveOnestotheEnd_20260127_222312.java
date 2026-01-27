// Last updated: 1/27/2026, 10:23:12 PM
1class Solution {
2
3    static class Edge {
4        int to, w;
5        Edge(int t, int w) {
6            this.to = t;
7            this.w = w;
8        }
9    }
10
11    public int minCost(int n, int[][] edges) {
12
13        List<Edge>[] adj = new ArrayList[n];
14        List<Edge>[] rev = new ArrayList[n];
15
16        for (int i = 0; i < n; i++) {
17            adj[i] = new ArrayList<>();
18            rev[i] = new ArrayList<>();
19        }
20
21        for (int[] e : edges) {
22            int u = e[0], v = e[1], w = e[2];
23            adj[u].add(new Edge(v, w));
24            rev[v].add(new Edge(u, w)); // incoming
25        }
26
27        long[] dist = new long[n];
28        Arrays.fill(dist, Long.MAX_VALUE);
29
30        PriorityQueue<long[]> pq = new PriorityQueue<>(
31            Comparator.comparingLong(a -> a[1])
32        );
33
34        dist[0] = 0;
35        pq.offer(new long[]{0, 0});
36
37        while (!pq.isEmpty()) {
38            long[] cur = pq.poll();
39            int u = (int) cur[0];
40            long d = cur[1];
41
42            if (d > dist[u]) continue;
43
44            // normal edges
45            for (Edge e : adj[u]) {
46                if (dist[e.to] > d + e.w) {
47                    dist[e.to] = d + e.w;
48                    pq.offer(new long[]{e.to, dist[e.to]});
49                }
50            }
51
52            // reversed edges using switch at u
53            for (Edge e : rev[u]) {
54                long nd = d + 2L * e.w;
55                if (dist[e.to] > nd) {
56                    dist[e.to] = nd;
57                    pq.offer(new long[]{e.to, nd});
58                }
59            }
60        }
61
62        return dist[n - 1] == Long.MAX_VALUE ? -1 : (int) dist[n - 1];
63    }
64}
65