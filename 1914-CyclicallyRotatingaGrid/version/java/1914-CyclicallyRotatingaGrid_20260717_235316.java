// Last updated: 7/17/2026, 11:53:16 PM
1class Solution {
2    public int[][] rotateGrid(int[][] grid, int k) {
3        int m = grid.length;
4        int n = grid[0].length;
5
6        int layers = Math.min(m, n) / 2;
7
8        for (int layer = 0; layer < layers; layer++) {
9
10            ArrayList<Integer> list = new ArrayList<>();
11
12            int top = layer;
13            int left = layer;
14            int bottom = m - layer - 1;
15            int right = n - layer - 1;
16
17            // top row
18            for (int j = left; j <= right; j++)
19                list.add(grid[top][j]);
20
21            // right column
22            for (int i = top + 1; i <= bottom - 1; i++)
23                list.add(grid[i][right]);
24
25            // bottom row
26            for (int j = right; j >= left; j--)
27                list.add(grid[bottom][j]);
28
29            // left column
30            for (int i = bottom - 1; i >= top + 1; i--)
31                list.add(grid[i][left]);
32
33            int len = list.size();
34            int shift = k % len;
35
36            ArrayList<Integer> rotated = new ArrayList<>(Collections.nCopies(len, 0));
37
38            // left rotation
39            for (int i = 0; i < len; i++) {
40                rotated.set(i, list.get((i + shift) % len));
41            }
42
43            int idx = 0;
44
45            // top row
46            for (int j = left; j <= right; j++)
47                grid[top][j] = rotated.get(idx++);
48
49            // right column
50            for (int i = top + 1; i <= bottom - 1; i++)
51                grid[i][right] = rotated.get(idx++);
52
53            // bottom row
54            for (int j = right; j >= left; j--)
55                grid[bottom][j] = rotated.get(idx++);
56
57            // left column
58            for (int i = bottom - 1; i >= top + 1; i--)
59                grid[i][left] = rotated.get(idx++);
60        }
61
62        return grid;
63    }
64}