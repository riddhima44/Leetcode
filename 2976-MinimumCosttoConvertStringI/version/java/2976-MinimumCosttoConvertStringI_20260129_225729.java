// Last updated: 1/29/2026, 10:57:29 PM
1class Solution {
2    public long minimumCost(
3        String source,
4        String target,
5        char[] original,
6        char[] changed,
7        int[] cost
8    ) {
9        final long INF = (long) 1e18;
10        long[][] dist = new long[26][26];
11        for (int i = 0; i < 26; i++) {
12            for (int j = 0; j < 26; j++) {
13                dist[i][j] = (i == j) ? 0 : INF;
14            }
15        }
16        for (int i = 0; i < original.length; i++) {
17            int u = original[i] - 'a';
18            int v = changed[i] - 'a';
19            dist[u][v] = Math.min(dist[u][v], cost[i]);
20        }
21        for (int k = 0; k < 26; k++) {
22            for (int i = 0; i < 26; i++) {
23                for (int j = 0; j < 26; j++) {
24                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
25                        dist[i][j] = dist[i][k] + dist[k][j];
26                    }
27                }
28            }
29        }
30        long total = 0;
31        for (int i = 0; i < source.length(); i++) {
32            int s = source.charAt(i) - 'a';
33            int t = target.charAt(i) - 'a';
34            if (dist[s][t] == INF) {
35                return -1;
36            }
37            total += dist[s][t];
38        }
39        return total;
40    }
41}