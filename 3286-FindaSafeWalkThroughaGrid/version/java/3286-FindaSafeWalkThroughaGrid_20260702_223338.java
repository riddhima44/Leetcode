// Last updated: 7/2/2026, 10:33:38 PM
1import java.util.*;
2
3class Solution {
4    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
5        int m = grid.size();
6        int n = grid.get(0).size();
7
8        int[][] dist = new int[m][n];
9        for (int[] row : dist)
10            Arrays.fill(row, Integer.MAX_VALUE);
11
12        Deque<int[]> dq = new ArrayDeque<>();
13
14        dist[0][0] = grid.get(0).get(0);
15        dq.offerFirst(new int[]{0, 0});
16
17        int[] dr = {-1, 1, 0, 0};
18        int[] dc = {0, 0, -1, 1};
19
20        while (!dq.isEmpty()) {
21            int[] cur = dq.pollFirst();
22            int r = cur[0];
23            int c = cur[1];
24
25            for (int k = 0; k < 4; k++) {
26                int nr = r + dr[k];
27                int nc = c + dc[k];
28
29                if (nr < 0 || nr >= m || nc < 0 || nc >= n)
30                    continue;
31
32                int w = grid.get(nr).get(nc);
33                int newCost = dist[r][c] + w;
34
35                if (newCost < dist[nr][nc]) {
36                    dist[nr][nc] = newCost;
37
38                    if (w == 0)
39                        dq.offerFirst(new int[]{nr, nc});
40                    else
41                        dq.offerLast(new int[]{nr, nc});
42                }
43            }
44        }
45
46        return dist[m - 1][n - 1] < health;
47    }
48}