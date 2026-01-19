// Last updated: 1/19/2026, 9:57:44 PM
class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int ans = Integer.MIN_VALUE;

        for (int r = 0; r < k; r++) {
            int sum = 0;
            // go backwards along this modulo-k chain
            for (int i = r + ((n - 1 - r) / k) * k; i >= r; i -= k) {
                sum += energy[i];
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }
}
