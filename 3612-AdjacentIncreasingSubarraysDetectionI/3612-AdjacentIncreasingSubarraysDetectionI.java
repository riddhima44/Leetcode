// Last updated: 1/19/2026, 9:57:36 PM
class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();

        // Boolean array: inc[i] = true if subarray nums[i..i+k-1] is strictly increasing
        boolean[] inc = new boolean[n];

        for (int i = 0; i + k <= n; i++) {
            boolean ok = true;
            for (int j = i; j + 1 < i + k; j++) {
                if (nums.get(j) >= nums.get(j + 1)) {
                    ok = false;
                    break;
                }
            }
            inc[i] = ok;
        }

        // Check adjacent subarrays i and i+k
        for (int i = 0; i + 2 * k <= n; i++) {
            if (inc[i] && inc[i + k]) return true;
        }

        return false;
    }
}
