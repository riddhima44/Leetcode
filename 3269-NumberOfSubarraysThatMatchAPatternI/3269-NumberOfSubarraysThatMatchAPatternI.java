// Last updated: 1/19/2026, 9:57:55 PM
class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int n = nums.length;
        int m = pattern.length;
        int count = 0;

        // We need subarrays of size m+1
        for (int i = 0; i + m < n; i++) {
            boolean ok = true;

            for (int k = 0; k < m; k++) {
                int a = nums[i + k];
                int b = nums[i + k + 1];

                if (pattern[k] == 1 && !(b > a)) { ok = false; break; }
                if (pattern[k] == 0 && !(b == a)) { ok = false; break; }
                if (pattern[k] == -1 && !(b < a)) { ok = false; break; }
            }

            if (ok) count++;
        }

        return count;
    }
}
