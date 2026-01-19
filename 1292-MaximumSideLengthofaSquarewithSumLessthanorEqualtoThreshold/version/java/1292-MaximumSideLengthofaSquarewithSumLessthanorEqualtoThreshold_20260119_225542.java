// Last updated: 1/19/2026, 10:55:42 PM
1class Solution {
2    public int maxSideLength(int[][] mat, int threshold) {
3        int m = mat.length, n = mat[0].length;
4
5        // 1) Prefix Sum
6        int[][] pref = new int[m + 1][n + 1];
7        for (int i = 1; i <= m; i++) {
8            for (int j = 1; j <= n; j++) {
9                pref[i][j] = mat[i - 1][j - 1]
10                           + pref[i - 1][j]
11                           + pref[i][j - 1]
12                           - pref[i - 1][j - 1];
13            }
14        }
15
16        // 2) Binary Search on side length
17        int low = 1, high = Math.min(m, n), ans = 0;
18
19        while (low <= high) {
20            int mid = (low + high) / 2;
21            if (existsSquare(pref, mid, threshold, m, n)) {
22                ans = mid;
23                low = mid + 1;   // try bigger
24            } else {
25                high = mid - 1;  // try smaller
26            }
27        }
28
29        return ans;
30    }
31
32    private boolean existsSquare(int[][] pref, int k, int threshold, int m, int n) {
33        for (int i = 0; i + k <= m; i++) {
34            for (int j = 0; j + k <= n; j++) {
35                int sum = pref[i + k][j + k]
36                        - pref[i][j + k]
37                        - pref[i + k][j]
38                        + pref[i][j];
39                if (sum <= threshold) return true;
40            }
41        }
42        return false;
43    }
44}
45