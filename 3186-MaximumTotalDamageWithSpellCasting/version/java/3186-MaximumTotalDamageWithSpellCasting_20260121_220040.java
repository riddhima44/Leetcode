// Last updated: 1/21/2026, 10:00:40 PM
1class Solution {
2    public int trapRainWater(int[][] heightMap) {
3        int m = heightMap.length;
4        int n = heightMap[0].length;
5
6        if (m < 3 || n < 3) return 0;
7
8        boolean[][] visited = new boolean[m][n];
9        PriorityQueue<int[]> pq = new PriorityQueue<>(
10            (a, b) -> a[0] - b[0]
11        );
12
13        // Add all boundary cells
14        for (int i = 0; i < m; i++) {
15            pq.offer(new int[]{heightMap[i][0], i, 0});
16            pq.offer(new int[]{heightMap[i][n - 1], i, n - 1});
17            visited[i][0] = true;
18            visited[i][n - 1] = true;
19        }
20
21        for (int j = 1; j < n - 1; j++) {
22            pq.offer(new int[]{heightMap[0][j], 0, j});
23            pq.offer(new int[]{heightMap[m - 1][j], m - 1, j});
24            visited[0][j] = true;
25            visited[m - 1][j] = true;
26        }
27
28        int water = 0;
29        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
30
31        while (!pq.isEmpty()) {
32            int[] cur = pq.poll();
33            int h = cur[0], r = cur[1], c = cur[2];
34
35            for (int[] d : dirs) {
36                int nr = r + d[0];
37                int nc = c + d[1];
38
39                if (nr < 0 || nc < 0 || nr >= m || nc >= n || visited[nr][nc])
40                    continue;
41
42                visited[nr][nc] = true;
43
44                int nh = heightMap[nr][nc];
45                if (nh < h) {
46                    water += h - nh;
47                }
48
49                pq.offer(new int[]{Math.max(h, nh), nr, nc});
50            }
51        }
52
53        return water;
54    }
55}
56