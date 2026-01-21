// Last updated: 1/21/2026, 10:08:09 PM
1class Solution {
2    public int[] findDiagonalOrder(int[][] mat) {
3        int m = mat.length;
4        int n = mat[0].length;
5
6        int[] res = new int[m * n];
7        int r = 0, c = 0;
8        int dir = 1; // 1 = up-right, -1 = down-left
9
10        for (int i = 0; i < m * n; i++) {
11            res[i] = mat[r][c];
12
13            if (dir == 1) { // moving up-right
14                if (c == n - 1) {
15                    r++;
16                    dir = -1;
17                } else if (r == 0) {
18                    c++;
19                    dir = -1;
20                } else {
21                    r--;
22                    c++;
23                }
24            } else { // moving down-left
25                if (r == m - 1) {
26                    c++;
27                    dir = 1;
28                } else if (c == 0) {
29                    r++;
30                    dir = 1;
31                } else {
32                    r++;
33                    c--;
34                }
35            }
36        }
37
38        return res;
39    }
40}
41