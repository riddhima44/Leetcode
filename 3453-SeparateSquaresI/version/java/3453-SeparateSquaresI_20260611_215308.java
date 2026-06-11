// Last updated: 6/11/2026, 9:53:08 PM
1class Solution {
2
3    int[] arr;
4    int d;
5    int[] dp;
6
7    public int maxJumps(int[] arr, int d) {
8        this.arr = arr;
9        this.d = d;
10
11        int n = arr.length;
12        dp = new int[n];
13
14        int ans = 1;
15
16        for (int i = 0; i < n; i++) {
17            ans = Math.max(ans, dfs(i));
18        }
19
20        return ans;
21    }
22
23    private int dfs(int i) {
24
25        if (dp[i] != 0)
26            return dp[i];
27
28        int best = 1;
29
30        // left
31        for (int j = i - 1; j >= Math.max(0, i - d); j--) {
32
33            if (arr[j] >= arr[i])
34                break;
35
36            best = Math.max(best, 1 + dfs(j));
37        }
38
39        // right
40        for (int j = i + 1; j <= Math.min(arr.length - 1, i + d); j++) {
41
42            if (arr[j] >= arr[i])
43                break;
44
45            best = Math.max(best, 1 + dfs(j));
46        }
47
48        return dp[i] = best;
49    }
50}