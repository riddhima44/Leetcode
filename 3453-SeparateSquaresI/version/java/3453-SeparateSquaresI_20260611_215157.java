// Last updated: 6/11/2026, 9:51:57 PM
1class Solution {
2
3    class DSU {
4        int[] parent;
5        int[] rank;
6
7        DSU(int n) {
8            parent = new int[n];
9            rank = new int[n];
10
11            for (int i = 0; i < n; i++)
12                parent[i] = i;
13        }
14
15        int find(int x) {
16            if (parent[x] != x)
17                parent[x] = find(parent[x]);
18            return parent[x];
19        }
20
21        void union(int a, int b) {
22            int pa = find(a);
23            int pb = find(b);
24
25            if (pa == pb) return;
26
27            if (rank[pa] < rank[pb]) {
28                parent[pa] = pb;
29            } else if (rank[pb] < rank[pa]) {
30                parent[pb] = pa;
31            } else {
32                parent[pb] = pa;
33                rank[pa]++;
34            }
35        }
36    }
37
38    public int minimumHammingDistance(int[] source,
39                                      int[] target,
40                                      int[][] allowedSwaps) {
41
42        int n = source.length;
43
44        DSU dsu = new DSU(n);
45
46        for (int[] e : allowedSwaps) {
47            dsu.union(e[0], e[1]);
48        }
49
50        Map<Integer, List<Integer>> groups = new HashMap<>();
51
52        for (int i = 0; i < n; i++) {
53            int root = dsu.find(i);
54            groups.computeIfAbsent(root, k -> new ArrayList<>())
55                  .add(i);
56        }
57
58        int ans = 0;
59
60        for (List<Integer> indices : groups.values()) {
61
62            Map<Integer, Integer> freq = new HashMap<>();
63
64            for (int idx : indices) {
65                freq.put(source[idx],
66                         freq.getOrDefault(source[idx], 0) + 1);
67            }
68
69            for (int idx : indices) {
70                int val = target[idx];
71
72                if (freq.getOrDefault(val, 0) > 0) {
73                    freq.put(val, freq.get(val) - 1);
74                } else {
75                    ans++;
76                }
77            }
78        }
79
80        return ans;
81    }
82}