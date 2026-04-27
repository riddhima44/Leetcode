// Last updated: 4/28/2026, 1:26:13 AM
1import java.util.*;
2
3class Solution {
4    public int hIndex(int[] citations) {
5        Arrays.sort(citations);
6        int n = citations.length;
7
8        for (int i = 0; i < n; i++) {
9            int h = n - i;
10            if (citations[i] >= h) {
11                return h;
12            }
13        }
14
15        return 0;
16    }
17}