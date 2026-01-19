// Last updated: 1/19/2026, 10:45:24 PM
class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        long cnt = 0;

        for (int x : nums) {
            if (x == 0) {
                cnt++;
            } else {
                ans += cnt * (cnt + 1) / 2;
                cnt = 0;
            }
        }

        // last block of zeros (if array ends with 0)
        ans += cnt * (cnt + 1) / 2;

        return ans;
    }
}
