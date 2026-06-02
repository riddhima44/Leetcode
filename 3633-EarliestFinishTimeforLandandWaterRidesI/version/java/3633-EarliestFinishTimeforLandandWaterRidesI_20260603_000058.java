// Last updated: 6/3/2026, 12:00:58 AM
1class Solution {
2    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
3                                  int[] waterStartTime, int[] waterDuration) {
4
5        int ans = Integer.MAX_VALUE;
6
7        for (int i = 0; i < landStartTime.length; i++) {
8            for (int j = 0; j < waterStartTime.length; j++) {
9
10                // Land -> Water
11                int landFinish = landStartTime[i] + landDuration[i];
12
13                int waterStart = Math.max(landFinish, waterStartTime[j]);
14
15                int total1 = waterStart + waterDuration[j];
16
17                // Water -> Land
18                int waterFinish = waterStartTime[j] + waterDuration[j];
19
20                int landStart = Math.max(waterFinish, landStartTime[i]);
21
22                int total2 = landStart + landDuration[i];
23
24                ans = Math.min(ans, Math.min(total1, total2));
25            }
26        }
27
28        return ans;
29    }
30}