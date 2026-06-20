// Last updated: 6/20/2026, 7:49:24 PM
1class Solution {
2    public int[] leftRightDifference(int[] nums) {
3        int n = nums.length;
4        int[] ans = new int[n];
5
6        int totalSum = 0;
7        for (int num : nums) {
8            totalSum += num;
9        }
10
11        int leftSum = 0;
12
13        for (int i = 0; i < n; i++) {
14            int rightSum = totalSum - leftSum - nums[i];
15            ans[i] = Math.abs(leftSum - rightSum);
16            leftSum += nums[i];
17        }
18
19        return ans;
20    }
21}