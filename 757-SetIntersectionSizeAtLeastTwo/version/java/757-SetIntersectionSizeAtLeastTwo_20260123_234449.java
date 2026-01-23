// Last updated: 1/23/2026, 11:44:49 PM
1import java.util.*;
2
3class Solution {
4    public int intersectionSizeTwo(int[][] intervals) {
5        Arrays.sort(intervals, (a, b) -> {
6            if (a[1] != b[1]) return a[1] - b[1];
7            return b[0] - a[0];
8        });
9
10        List<Integer> chosen = new ArrayList<>();
11
12        for (int[] in : intervals) {
13            int l = in[0], r = in[1];
14            int count = 0;
15
16            for (int i = chosen.size() - 1; i >= 0; i--) {
17                if (chosen.get(i) < l) break;
18                count++;
19            }
20
21            if (count >= 2) continue;
22            if (count == 1) {
23                chosen.add(r);
24            } else {
25                chosen.add(r - 1);
26                chosen.add(r);
27            }
28        }
29        return chosen.size();
30    }
31}
32