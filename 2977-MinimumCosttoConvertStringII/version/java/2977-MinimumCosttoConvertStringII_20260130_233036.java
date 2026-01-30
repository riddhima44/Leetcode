// Last updated: 1/30/2026, 11:30:36 PM
1import java.util.*;
2
3class Solution {
4    static class TrieNode {
5        TrieNode[] ch = new TrieNode[26];
6        int id = -1;
7    }
8
9    public long minimumCost(String source, String target,
10                            String[] original, String[] changed, int[] cost) {
11        int m = original.length;
12
13        TrieNode root = new TrieNode();
14        Map<String, Integer> idMap = new HashMap<>();
15        int idCnt = 0;
16
17        final long INF = (long)4e18;
18
19        long[][] dist = new long[2 * m + 5][2 * m + 5];
20        for (int i = 0; i < dist.length; i++) {
21            Arrays.fill(dist[i], INF);
22            dist[i][i] = 0;
23        }
24
25        for (int i = 0; i < m; i++) {
26            int a = getId(root, original[i], idMap, idCnt);
27            if (a == idCnt) idCnt++;
28            int b = getId(root, changed[i], idMap, idCnt);
29            if (b == idCnt) idCnt++;
30            dist[a][b] = Math.min(dist[a][b], (long)cost[i]);
31        }
32
33        int nIds = idCnt;
34
35        for (int k = 0; k < nIds; k++) {
36            for (int i = 0; i < nIds; i++) {
37                if (dist[i][k] == INF) continue;
38                for (int j = 0; j < nIds; j++) {
39                    if (dist[k][j] == INF) continue;
40                    long cand = dist[i][k] + dist[k][j];
41                    if (cand < dist[i][j]) dist[i][j] = cand;
42                }
43            }
44        }
45
46        int n = source.length();
47        Long[] dp = new Long[n + 1];
48        long ans = solve(0, source, target, root, dist, dp, INF);
49
50        if (ans >= INF) return -1;
51        return ans;
52    }
53
54    private int getId(TrieNode root, String s,
55                      Map<String, Integer> map, int nextId) {
56        Integer cached = map.get(s);
57        if (cached != null) return cached;
58
59        TrieNode cur = root;
60        for (char c : s.toCharArray()) {
61            int idx = c - 'a';
62            if (cur.ch[idx] == null) cur.ch[idx] = new TrieNode();
63            cur = cur.ch[idx];
64        }
65        if (cur.id == -1) {
66            cur.id = nextId;
67        }
68        map.put(s, cur.id);
69        return cur.id;
70    }
71
72    private long solve(int i, String s, String t, TrieNode root,
73                       long[][] dist, Long[] dp, long INF) {
74        int n = s.length();
75        if (i == n) return 0L;
76        if (dp[i] != null) return dp[i];
77
78        long best = INF;
79
80        if (s.charAt(i) == t.charAt(i)) {
81            long nxt = solve(i + 1, s, t, root, dist, dp, INF);
82            if (nxt < INF) best = nxt;
83        }
84
85        TrieNode ps = root, pt = root;
86        for (int j = i; j < n; j++) {
87            int cs = s.charAt(j) - 'a';
88            int ct = t.charAt(j) - 'a';
89            if (ps.ch[cs] == null || pt.ch[ct] == null) break;
90            ps = ps.ch[cs];
91            pt = pt.ch[ct];
92
93            if (ps.id != -1 && pt.id != -1) {
94                long cst = dist[ps.id][pt.id];
95                if (cst < INF) {
96                    long nxt = solve(j + 1, s, t, root, dist, dp, INF);
97                    if (nxt < INF) {
98                        long cand = cst + nxt;
99                        if (cand < best) best = cand;
100                    }
101                }
102            }
103        }
104
105        dp[i] = best;
106        return best;
107    }
108}