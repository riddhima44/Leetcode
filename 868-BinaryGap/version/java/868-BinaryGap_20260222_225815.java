// Last updated: 2/22/2026, 10:58:15 PM
1class Solution {
2    public int binaryGap(int n) {
3        int lastPos = -1;
4        int maxDist = 0;
5        int position = 0;
6        
7        while (n > 0) {
8            if ((n & 1) == 1) {
9                if (lastPos != -1) {
10                    maxDist = Math.max(maxDist, position - lastPos);
11                }
12                lastPos = position;
13            }
14            n >>= 1;
15            position++;
16        }
17        
18        return maxDist;
19    }
20}