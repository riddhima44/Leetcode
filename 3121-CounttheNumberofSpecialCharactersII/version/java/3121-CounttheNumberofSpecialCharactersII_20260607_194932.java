// Last updated: 6/7/2026, 7:49:32 PM
1class Solution {
2    public int minJumps(int[] nums) {
3        int n = nums.length;
4        if (n == 1) return 0;
5
6        int max = 0;
7        for (int x : nums) max = Math.max(max, x);
8
9        int[] spf = new int[max + 1];
10        for (int i = 0; i <= max; i++) spf[i] = i;
11
12        for (int i = 2; i * i <= max; i++) {
13            if (spf[i] == i) {
14                for (int j = i * i; j <= max; j += i) {
15                    if (spf[j] == j) spf[j] = i;
16                }
17            }
18        }
19
20        Map<Integer, List<Integer>> map = new HashMap<>();
21
22        for (int i = 0; i < n; i++) {
23            int x = nums[i];
24
25            while (x > 1) {
26                int p = spf[x];
27
28                map.computeIfAbsent(p, k -> new ArrayList<>()).add(i);
29
30                while (x % p == 0) x /= p;
31            }
32        }
33
34        boolean[] vis = new boolean[n];
35        ArrayDeque<Integer> q = new ArrayDeque<>();
36
37        q.offer(0);
38        vis[0] = true;
39
40        int steps = 0;
41
42        while (!q.isEmpty()) {
43            int size = q.size();
44
45            while (size-- > 0) {
46                int i = q.poll();
47
48                if (i == n - 1) return steps;
49
50                if (i - 1 >= 0 && !vis[i - 1]) {
51                    vis[i - 1] = true;
52                    q.offer(i - 1);
53                }
54
55                if (i + 1 < n && !vis[i + 1]) {
56                    vis[i + 1] = true;
57                    q.offer(i + 1);
58                }
59
60                int val = nums[i];
61
62                // val must be prime
63                if (val > 1 && spf[val] == val) {
64                    List<Integer> list = map.remove(val);
65
66                    if (list != null) {
67                        for (int idx : list) {
68                            if (!vis[idx]) {
69                                vis[idx] = true;
70                                q.offer(idx);
71                            }
72                        }
73                    }
74                }
75            }
76
77            steps++;
78        }
79
80        return -1;
81    }
82}