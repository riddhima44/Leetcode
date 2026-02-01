// Last updated: 2/1/2026, 9:26:10 PM
1class Solution {
2    public int minimumCost(int[] nums) {
3        int n = nums.length;
4        int ans = Integer.MAX_VALUE;
5
6        // nums[0] is always included
7        for (int i = 1; i < n; i++) {
8            for (int j = i + 1; j < n; j++) {
9                ans = Math.min(ans, nums[0] + nums[i] + nums[j]);
10            }
11        }
12        return ans;
13    }
14}
15