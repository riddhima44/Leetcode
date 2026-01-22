// Last updated: 1/22/2026, 10:51:03 PM
1import java.util.*;
2
3class Solution {
4    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
5        int maxH = longestConsecutive(hBars);
6        int maxV = longestConsecutive(vBars);
7
8        int side = Math.min(maxH, maxV) + 1;
9        return side * side;
10    }
11
12    private int longestConsecutive(int[] bars) {
13        Arrays.sort(bars);
14
15        int maxLen = 1;
16        int currLen = 1;
17
18        for (int i = 1; i < bars.length; i++) {
19            if (bars[i] == bars[i - 1] + 1) {
20                currLen++;
21            } else {
22                currLen = 1;
23            }
24            maxLen = Math.max(maxLen, currLen);
25        }
26
27        return maxLen;
28    }
29}
30