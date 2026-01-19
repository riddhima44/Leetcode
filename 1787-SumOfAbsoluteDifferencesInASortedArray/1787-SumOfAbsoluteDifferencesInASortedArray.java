// Last updated: 1/19/2026, 10:46:55 PM
class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int totalSum = 0;
        for (int x : nums) totalSum += x;

        int prefixSum = 0;

        for (int i = 0; i < n; i++) {
            int left = nums[i] * i - prefixSum;
            int right = (totalSum - prefixSum - nums[i]) - nums[i] * (n - i - 1);
            result[i] = left + right;
            prefixSum += nums[i];
        }

        return result;
    }
}
