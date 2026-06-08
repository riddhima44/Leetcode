// Last updated: 6/9/2026, 12:47:23 AM
1import java.util.*;
2
3class Solution {
4    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
5        Collections.sort(processorTime);
6        tasks.sort(Collections.reverseOrder());
7
8        int ans = 0;
9
10        for (int i = 0; i < processorTime.size(); i++) {
11            ans = Math.max(ans,
12                    processorTime.get(i) + tasks.get(4 * i));
13        }
14
15        return ans;
16    }
17}