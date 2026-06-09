// Last updated: 6/9/2026, 11:00:27 PM
1class Solution {
2    public int maximumJumps(int[] nums, int target) {
3        int n = nums.length;
4
5        int[] dp = new int[n];
6        Arrays.fill(dp, -1);
7        dp[0] = 0;
8
9        for (int i = 0; i < n; i++) {
10            if (dp[i] == -1) continue;
11
12            for (int j = i + 1; j < n; j++) {
13                long diff = (long) nums[j] - nums[i];
14
15                if (-target <= diff && diff <= target) {
16                    dp[j] = Math.max(dp[j], dp[i] + 1);
17                }
18            }
19        }
20
21        return dp[n - 1];
22    }
23}