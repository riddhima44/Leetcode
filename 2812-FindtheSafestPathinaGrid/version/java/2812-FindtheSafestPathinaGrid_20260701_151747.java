// Last updated: 7/1/2026, 3:17:47 PM
1class Solution {
2    int[] dr = {-1, 1, 0, 0};
3    int[] dc = {0, 0, -1, 1};
4
5    public int maximumSafenessFactor(List<List<Integer>> grid) {
6        int n = grid.size();
7        int[][] dist = new int[n][n];
8
9        for (int[] row : dist)
10            Arrays.fill(row, -1);
11
12        Queue<int[]> q = new LinkedList<>();
13
14        // Multi-source BFS from all thieves
15        for (int i = 0; i < n; i++) {
16            for (int j = 0; j < n; j++) {
17                if (grid.get(i).get(j) == 1) {
18                    dist[i][j] = 0;
19                    q.offer(new int[]{i, j});
20                }
21            }
22        }
23
24        while (!q.isEmpty()) {
25            int[] cur = q.poll();
26            int r = cur[0], c = cur[1];
27
28            for (int k = 0; k < 4; k++) {
29                int nr = r + dr[k];
30                int nc = c + dc[k];
31
32                if (nr >= 0 && nr < n && nc >= 0 && nc < n &&
33                        dist[nr][nc] == -1) {
34
35                    dist[nr][nc] = dist[r][c] + 1;
36                    q.offer(new int[]{nr, nc});
37                }
38            }
39        }
40
41        int low = 0;
42        int high = 2 * n;
43
44        while (low <= high) {
45            int mid = low + (high - low) / 2;
46
47            if (canReach(dist, mid)) {
48                low = mid + 1;
49            } else {
50                high = mid - 1;
51            }
52        }
53
54        return high;
55    }
56
57    private boolean canReach(int[][] dist, int safe) {
58        int n = dist.length;
59
60        if (dist[0][0] < safe || dist[n - 1][n - 1] < safe)
61            return false;
62
63        Queue<int[]> q = new LinkedList<>();
64        boolean[][] vis = new boolean[n][n];
65
66        q.offer(new int[]{0, 0});
67        vis[0][0] = true;
68
69        while (!q.isEmpty()) {
70            int[] cur = q.poll();
71            int r = cur[0], c = cur[1];
72
73            if (r == n - 1 && c == n - 1)
74                return true;
75
76            for (int k = 0; k < 4; k++) {
77                int nr = r + dr[k];
78                int nc = c + dc[k];
79
80                if (nr >= 0 && nr < n && nc >= 0 && nc < n &&
81                        !vis[nr][nc] &&
82                        dist[nr][nc] >= safe) {
83
84                    vis[nr][nc] = true;
85                    q.offer(new int[]{nr, nc});
86                }
87            }
88        }
89
90        return false;
91    }
92}