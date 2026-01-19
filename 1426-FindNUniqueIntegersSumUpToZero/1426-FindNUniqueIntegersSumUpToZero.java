// Last updated: 1/19/2026, 10:47:11 PM
class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int idx = 0;

        for (int i = 1; i <= n / 2; i++) {
            ans[idx++] = -i;
            ans[idx++] = i;
        }

        if (n % 2 == 1) {
            ans[idx] = 0;
        }

        return ans;
    }
}
