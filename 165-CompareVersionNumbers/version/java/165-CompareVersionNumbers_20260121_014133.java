// Last updated: 1/21/2026, 1:41:33 AM
1class Solution {
2    public long minOperations(int[][] queries) {
3        long answer = 0;
4
5        // Precompute powers of 4
6        long[] pow4 = new long[20];
7        pow4[0] = 1;
8        for (int i = 1; i < 20; i++) {
9            pow4[i] = pow4[i - 1] * 4;
10        }
11
12        for (int[] q : queries) {
13            long l = q[0], r = q[1];
14            long totalSteps = 0;
15
16            for (int k = 1; k < 20; k++) {
17                long start = pow4[k - 1];
18                long end = pow4[k] - 1;
19
20                long left = Math.max(l, start);
21                long right = Math.min(r, end);
22
23                if (left <= right) {
24                    long count = right - left + 1;
25                    totalSteps += count * k;
26                }
27            }
28
29            answer += (totalSteps + 1) / 2; // ceil(totalSteps / 2)
30        }
31
32        return answer;
33    }
34}
35