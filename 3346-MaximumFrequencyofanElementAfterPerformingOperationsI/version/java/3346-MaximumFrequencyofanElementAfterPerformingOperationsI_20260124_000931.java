// Last updated: 1/24/2026, 12:09:31 AM
1class Solution {
2    public int maxFrequency(int[] nums, int k, int numOperations) {
3        int MAX = 200_000;
4        int[] diff = new int[MAX + 2];
5        int[] freq = new int[MAX + 2];
6
7        for (int x : nums) {
8            freq[x]++;
9            int l = Math.max(0, x - k);
10            int r = x + k;
11            diff[l]++;
12            diff[r + 1]--;
13        }
14
15        int cover = 0;
16        int ans = 0;
17
18        for (int x = 0; x <= MAX; x++) {
19            cover += diff[x];
20            if (cover == 0) continue;
21
22            int possible = Math.min(cover, freq[x] + numOperations);
23            ans = Math.max(ans, possible);
24        }
25        return ans;
26    }
27}
28