// Last updated: 2/11/2026, 10:18:25 PM
1class Solution {
2
3    public int minRectanglesToCoverPoints(int[][] points, int w) {
4
5        // Step 1: sort by x
6        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
7
8        int rectangles = 0;
9
10        int i = 0;
11        int n = points.length;
12
13        while (i < n) {
14
15            rectangles++;
16
17            // Start rectangle at this x
18            long startX = points[i][0];
19            long endX = startX + w;
20
21            // Cover all points within width
22            while (i < n && points[i][0] <= endX) {
23                i++;
24            }
25        }
26
27        return rectangles;
28    }
29}
30