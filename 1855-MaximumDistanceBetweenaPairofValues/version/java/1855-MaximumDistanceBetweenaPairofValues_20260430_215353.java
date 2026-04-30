// Last updated: 4/30/2026, 9:53:53 PM
1class Solution {
2    public int minimumDistance(String word) {
3        int n = word.length();
4        int[][] dp = new int[n][26];
5
6        // initialize
7        for (int i = 0; i < n; i++) {
8            Arrays.fill(dp[i], Integer.MAX_VALUE);
9        }
10
11        // first character → free placement
12        for (int j = 0; j < 26; j++) {
13            dp[0][j] = 0;
14        }
15
16        for (int i = 1; i < n; i++) {
17            int curr = word.charAt(i) - 'A';
18            int prev = word.charAt(i - 1) - 'A';
19
20            for (int j = 0; j < 26; j++) {
21                if (dp[i - 1][j] == Integer.MAX_VALUE) continue;
22
23                // case 1: same finger types
24                int cost1 = dp[i - 1][j] + dist(prev, curr);
25                dp[i][j] = Math.min(dp[i][j], cost1);
26
27                // case 2: other finger types
28                int cost2 = dp[i - 1][j] + dist(j, curr);
29                dp[i][prev] = Math.min(dp[i][prev], cost2);
30            }
31        }
32
33        int ans = Integer.MAX_VALUE;
34        for (int j = 0; j < 26; j++) {
35            ans = Math.min(ans, dp[n - 1][j]);
36        }
37
38        return ans;
39    }
40
41    private int dist(int a, int b) {
42        int x1 = a / 6, y1 = a % 6;
43        int x2 = b / 6, y2 = b % 6;
44        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
45    }
46}