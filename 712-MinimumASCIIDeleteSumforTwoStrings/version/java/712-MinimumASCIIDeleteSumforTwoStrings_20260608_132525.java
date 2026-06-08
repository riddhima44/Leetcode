// Last updated: 6/8/2026, 1:25:25 PM
1class Solution {
2    public boolean isGood(int[] nums) {
3        int n = 0;
4
5        for (int num : nums) {
6            n = Math.max(n, num);
7        }
8
9        if (nums.length != n + 1) {
10            return false;
11        }
12
13        int[] freq = new int[n + 1];
14
15        for (int num : nums) {
16            if (num > n) return false;
17            freq[num]++;
18        }
19
20        for (int i = 1; i < n; i++) {
21            if (freq[i] != 1) {
22                return false;
23            }
24        }
25
26        return freq[n] == 2;
27    }
28}