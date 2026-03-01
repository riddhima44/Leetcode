// Last updated: 3/1/2026, 1:59:14 PM
1class Solution {
2    public boolean isMatch(String s, String p) {
3
4        int n = s.length();
5        int m = p.length();
6
7        boolean[][] dp = new boolean[n+1][m+1];
8
9        dp[0][0] = true;
10
11        // handle empty string
12        for(int j = 2; j <= m; j++){
13            if(p.charAt(j-1) == '*')
14                dp[0][j] = dp[0][j-2];
15        }
16
17        for(int i = 1; i <= n; i++){
18            for(int j = 1; j <= m; j++){
19
20                char sc = s.charAt(i-1);
21                char pc = p.charAt(j-1);
22
23                if(pc == '.' || sc == pc){
24                    dp[i][j] = dp[i-1][j-1];
25                }
26                else if(pc == '*'){
27
28                    // zero occurrence
29                    dp[i][j] = dp[i][j-2];
30
31                    char prev = p.charAt(j-2);
32
33                    // one or more occurrence
34                    if(prev == '.' || prev == sc){
35                        dp[i][j] |= dp[i-1][j];
36                    }
37                }
38            }
39        }
40
41        return dp[n][m];
42    }
43}