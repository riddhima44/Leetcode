// Last updated: 7/5/2026, 10:23:07 PM
1class Solution {
2    public int[] pathsWithMaxScore(List<String> board) {
3        int n = board.size();
4        int MOD = 1_000_000_007;
5
6        int[][] score = new int[n][n];
7        int[][] ways = new int[n][n];
8
9        for (int i = 0; i < n; i++) {
10            Arrays.fill(score[i], -1);
11        }
12
13        score[0][0] = 0;
14        ways[0][0] = 1;
15
16        for (int i = 0; i < n; i++) {
17            for (int j = 0; j < n; j++) {
18
19                char c = board.get(i).charAt(j);
20
21                if (c == 'X') continue;
22                if (i == 0 && j == 0) continue;
23
24                int best = -1;
25                long cnt = 0;
26
27                int[][] dirs = {{-1,0},{0,-1},{-1,-1}};
28
29                for (int[] d : dirs) {
30                    int x = i + d[0];
31                    int y = j + d[1];
32
33                    if (x < 0 || y < 0) continue;
34                    if (score[x][y] == -1) continue;
35
36                    if (score[x][y] > best) {
37                        best = score[x][y];
38                        cnt = ways[x][y];
39                    } else if (score[x][y] == best) {
40                        cnt = (cnt + ways[x][y]) % MOD;
41                    }
42                }
43
44                if (best == -1) continue;
45
46                int val = 0;
47                if (c >= '1' && c <= '9')
48                    val = c - '0';
49
50                score[i][j] = best + val;
51                ways[i][j] = (int)(cnt % MOD);
52            }
53        }
54
55        if (ways[n - 1][n - 1] == 0)
56            return new int[]{0, 0};
57
58        return new int[]{
59                score[n - 1][n - 1],
60                ways[n - 1][n - 1]
61        };
62    }
63}