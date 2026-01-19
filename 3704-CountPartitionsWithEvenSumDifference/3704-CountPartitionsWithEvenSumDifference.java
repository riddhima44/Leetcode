// Last updated: 1/19/2026, 9:57:19 PM
class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;
        int total = 0;
        for (int x : nums) total += x;

        int left = 0;
        int ans = 0;

        for (int i = 0; i < n - 1; i++) {
            left += nums[i];
            int right = total - left;
            int diff = left - right;
            if (diff % 2 == 0) ans++;
        }

        return ans;
    }
}
