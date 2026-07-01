// Last updated: 7/1/2026, 3:20:34 PM
1class Solution {
2    public int orangesRotting(int[][] grid) {
3        int m = grid.length;
4        int n = grid[0].length;
5
6        Queue<int[]> q = new LinkedList<>();
7        int fresh = 0;
8
9        // Store all rotten oranges and count fresh ones
10        for (int i = 0; i < m; i++) {
11            for (int j = 0; j < n; j++) {
12                if (grid[i][j] == 2) {
13                    q.offer(new int[]{i, j});
14                } else if (grid[i][j] == 1) {
15                    fresh++;
16                }
17            }
18        }
19
20        if (fresh == 0)
21            return 0;
22
23        int minutes = 0;
24        int[] dr = {-1, 1, 0, 0};
25        int[] dc = {0, 0, -1, 1};
26
27        while (!q.isEmpty()) {
28            int size = q.size();
29            boolean rotten = false;
30
31            for (int i = 0; i < size; i++) {
32                int[] cur = q.poll();
33                int r = cur[0];
34                int c = cur[1];
35
36                for (int k = 0; k < 4; k++) {
37                    int nr = r + dr[k];
38                    int nc = c + dc[k];
39
40                    if (nr >= 0 && nr < m && nc >= 0 && nc < n &&
41                        grid[nr][nc] == 1) {
42
43                        grid[nr][nc] = 2;
44                        fresh--;
45                        q.offer(new int[]{nr, nc});
46                        rotten = true;
47                    }
48                }
49            }
50
51            if (rotten)
52                minutes++;
53        }
54
55        return fresh == 0 ? minutes : -1;
56    }
57}