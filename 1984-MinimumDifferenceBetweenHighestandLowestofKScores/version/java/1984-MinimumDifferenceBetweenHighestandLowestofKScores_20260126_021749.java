// Last updated: 1/26/2026, 2:17:49 AM
1
2class Solution {
3    public int minimumDifference(int[] nums, int k) {
4        if (k <= 1) return 0;
5
6        Arrays.sort(nums);
7
8        int minDiff = Integer.MAX_VALUE;
9        for (int i = 0; i + k - 1 < nums.length; i++) {
10            minDiff = Math.min(minDiff, nums[i + k - 1] - nums[i]);
11        }
12        return minDiff;
13    }
14}
15