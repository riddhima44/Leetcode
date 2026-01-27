// Last updated: 1/27/2026, 10:25:11 PM
1class Solution {
2    public int findSmallestInteger(int[] nums, int value) {
3
4        int[] count = new int[value];
5
6        // Count remainders
7        for (int x : nums) {
8            int r = x % value;
9            if (r < 0) r += value;   // critical for negatives
10            count[r]++;
11        }
12
13        int mex = 0;
14
15        // Greedily build 0,1,2,...
16        while (true) {
17            int r = mex % value;
18            if (count[r] == 0) {
19                return mex;
20            }
21            count[r]--;
22            mex++;
23        }
24    }
25}
26