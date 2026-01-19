// Last updated: 1/19/2026, 9:57:38 PM
class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        for (int start = 0; start + k <= n; start++) {
            // Count frequencies
            int[] freq = new int[51];

            for (int i = start; i < start + k; i++) {
                freq[nums[i]]++;
            }

            // Create list of (value, frequency) pairs
            List<int[]> list = new ArrayList<>();
            for (int v = 1; v <= 50; v++) {
                if (freq[v] > 0) {
                    list.add(new int[]{v, freq[v]});
                }
            }

            // Sort by (frequency DESC, value DESC)
            list.sort((a, b) -> {
                if (b[1] != a[1]) return b[1] - a[1];
                return b[0] - a[0];
            });

            int sum = 0;
            int taken = 0;

            // Take top x elements and sum freq * value
            for (int[] p : list) {
                if (taken == x) break;
                sum += p[0] * p[1];
                taken++;
            }

            ans[start] = sum;
        }

        return ans;
    }
}
