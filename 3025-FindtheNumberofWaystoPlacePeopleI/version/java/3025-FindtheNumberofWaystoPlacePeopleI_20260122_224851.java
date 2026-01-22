// Last updated: 1/22/2026, 10:48:51 PM
1class Solution {
2    public int numberOfPairs(int[][] points) {
3        int n = points.length;
4        int count = 0;
5
6        for (int i = 0; i < n; i++) {
7            int ax = points[i][0];
8            int ay = points[i][1];
9
10            for (int j = 0; j < n; j++) {
11                if (i == j) continue;
12
13                int bx = points[j][0];
14                int by = points[j][1];
15
16                // A must be upper-left OR form a valid line with B
17                // Reject only if A is strictly right or strictly below B
18                if (ax > bx || ay < by) continue;
19
20                // Same point (just safety)
21                if (ax == bx && ay == by) continue;
22
23                boolean valid = true;
24
25                // Check if any other point lies inside or on the rectangle/line
26                for (int k = 0; k < n; k++) {
27                    if (k == i || k == j) continue;
28
29                    int px = points[k][0];
30                    int py = points[k][1];
31
32                    if (px >= Math.min(ax, bx) && px <= Math.max(ax, bx) &&
33                        py >= Math.min(by, ay) && py <= Math.max(by, ay)) {
34                        valid = false;
35                        break;
36                    }
37                }
38
39                if (valid) count++;
40            }
41        }
42
43        return count;
44    }
45}
46