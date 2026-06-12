// Last updated: 6/12/2026, 11:23:24 PM
1class Solution {
2    public int minMoves(int[] nums, int limit) {
3        int n = nums.length;
4
5        int[] diff = new int[2 * limit + 2];
6
7        for (int i = 0; i < n / 2; i++) {
8            int a = nums[i];
9            int b = nums[n - 1 - i];
10
11            int low = Math.min(a, b) + 1;
12            int high = Math.max(a, b) + limit;
13            int sum = a + b;
14
15            // Start with cost 2 for every target sum
16            diff[2] += 2;
17
18            // Cost becomes 1 in [low, high]
19            diff[low] -= 1;
20            diff[high + 1] += 1;
21
22            // Cost becomes 0 at exact sum
23            diff[sum] -= 1;
24            diff[sum + 1] += 1;
25        }
26
27        int ans = Integer.MAX_VALUE;
28        int curr = 0;
29
30        for (int s = 2; s <= 2 * limit; s++) {
31            curr += diff[s];
32            ans = Math.min(ans, curr);
33        }
34
35        return ans;
36    }
37}