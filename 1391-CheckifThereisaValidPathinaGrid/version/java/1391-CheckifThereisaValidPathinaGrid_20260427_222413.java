// Last updated: 4/27/2026, 10:24:13 PM
1class Solution {
2    public boolean hasValidPath(int[][] grid) {
3        int m = grid.length, n = grid[0].length;
4
5        // Directions: {dx, dy}
6        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}}; // R, L, D, U
7
8        // Street type to allowed directions
9        Map<Integer, int[][]> map = new HashMap<>();
10        map.put(1, new int[][]{{0,1},{0,-1}});
11        map.put(2, new int[][]{{1,0},{-1,0}});
12        map.put(3, new int[][]{{0,-1},{1,0}});
13        map.put(4, new int[][]{{0,1},{1,0}});
14        map.put(5, new int[][]{{0,-1},{-1,0}});
15        map.put(6, new int[][]{{0,1},{-1,0}});
16
17        boolean[][] visited = new boolean[m][n];
18        Queue<int[]> q = new LinkedList<>();
19        q.offer(new int[]{0,0});
20        visited[0][0] = true;
21
22        while (!q.isEmpty()) {
23            int[] curr = q.poll();
24            int x = curr[0], y = curr[1];
25
26            if (x == m - 1 && y == n - 1) return true;
27
28            for (int[] d : map.get(grid[x][y])) {
29                int nx = x + d[0];
30                int ny = y + d[1];
31
32                if (nx < 0 || ny < 0 || nx >= m || ny >= n || visited[nx][ny]) continue;
33
34                // Check reverse direction exists in next cell
35                for (int[] back : map.get(grid[nx][ny])) {
36                    if (nx + back[0] == x && ny + back[1] == y) {
37                        visited[nx][ny] = true;
38                        q.offer(new int[]{nx, ny});
39                        break;
40                    }
41                }
42            }
43        }
44
45        return false;
46    }
47}