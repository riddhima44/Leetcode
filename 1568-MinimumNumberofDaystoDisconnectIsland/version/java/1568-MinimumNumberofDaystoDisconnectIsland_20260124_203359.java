// Last updated: 1/24/2026, 8:33:59 PM
1class Solution {
2    int m, n;
3    int[][] grid;
4    boolean[][] vis;
5    int[] dx = {1, -1, 0, 0};
6    int[] dy = {0, 0, 1, -1};
7
8    public int minDays(int[][] grid) {
9        this.grid = grid;
10        m = grid.length;
11        n = grid[0].length;
12
13        if (countIslands() != 1) return 0;
14
15        for (int i = 0; i < m; i++) {
16            for (int j = 0; j < n; j++) {
17                if (grid[i][j] == 1) {
18                    grid[i][j] = 0;
19                    if (countIslands() != 1) {
20                        grid[i][j] = 1;
21                        return 1;
22                    }
23                    grid[i][j] = 1;
24                }
25            }
26        }
27        return 2;
28    }
29
30    private int countIslands() {
31        vis = new boolean[m][n];
32        int count = 0;
33
34        for (int i = 0; i < m; i++) {
35            for (int j = 0; j < n; j++) {
36                if (grid[i][j] == 1 && !vis[i][j]) {
37                    dfs(i, j);
38                    count++;
39                }
40            }
41        }
42        return count;
43    }
44
45    private void dfs(int x, int y) {
46        vis[x][y] = true;
47        for (int d = 0; d < 4; d++) {
48            int nx = x + dx[d];
49            int ny = y + dy[d];
50            if (nx >= 0 && ny >= 0 && nx < m && ny < n &&
51                grid[nx][ny] == 1 && !vis[nx][ny]) {
52                dfs(nx, ny);
53            }
54        }
55    }
56}
57