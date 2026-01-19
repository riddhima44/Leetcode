// Last updated: 1/19/2026, 10:45:07 PM
class Solution {

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public int minOperations(int[] nums) {
        int n = nums.length;

        // Step 1: gcd of entire array
        int g = nums[0];
        for (int i = 1; i < n; i++) {
            g = gcd(g, nums[i]);
        }
        if (g != 1) return -1;

        // Step 2: count existing ones
        int ones = 0;
        for (int x : nums) {
            if (x == 1) ones++;
        }
        if (ones > 0) {
            return n - ones;
        }

        // Step 3: find shortest subarray with gcd = 1
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int currGcd = nums[i];
            for (int j = i + 1; j < n; j++) {
                currGcd = gcd(currGcd, nums[j]);
                if (currGcd == 1) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
        }

        // Step 4: total operations
        return minLen + n - 2;
    }
}
