// Last updated: 6/11/2026, 9:59:15 PM
1class Solution {
2    public int minimumCost(int[] cost) {
3        Arrays.sort(cost);
4
5        int ans = 0;
6        int cnt = 0;
7
8        for (int i = cost.length - 1; i >= 0; i--) {
9            cnt++;
10
11            if (cnt % 3 == 0) {
12                continue; // free candy
13            }
14
15            ans += cost[i];
16        }
17
18        return ans;
19    }
20}