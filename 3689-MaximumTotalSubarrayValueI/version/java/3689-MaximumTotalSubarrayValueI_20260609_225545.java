// Last updated: 6/9/2026, 10:55:45 PM
1class Solution {
2    public long maxTotalValue(int[] nums, int k) {
3        int mn = Integer.MAX_VALUE;
4        int mx = Integer.MIN_VALUE;
5        
6        for (int num : nums) {
7            mn = Math.min(mn, num);
8            mx = Math.max(mx, num);
9        }
10        
11        return 1L * k * (mx - mn);
12    }
13}