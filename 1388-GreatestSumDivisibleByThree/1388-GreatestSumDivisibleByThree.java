// Last updated: 1/19/2026, 10:47:15 PM
class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;

        int m1 = Integer.MAX_VALUE, m2 = Integer.MAX_VALUE;
        int n1 = Integer.MAX_VALUE, n2 = Integer.MAX_VALUE;

        for (int x : nums) {
            sum += x;

            if (x % 3 == 1) {
                if (x < m1) { m2 = m1; m1 = x; }
                else if (x < m2) m2 = x;
            }
            else if (x % 3 == 2) {
                if (x < n1) { n2 = n1; n1 = x; }
                else if (x < n2) n2 = x;
            }
        }

        if (sum % 3 == 0) return sum;

        int ans = 0;

        if (sum % 3 == 1) {
            int op1 = (m1 == Integer.MAX_VALUE) ? 0 : sum - m1;
            int op2 = (n1 == Integer.MAX_VALUE || n2 == Integer.MAX_VALUE) ? 0 : sum - (n1 + n2);
            ans = Math.max(op1, op2);
        } else {
            int op1 = (n1 == Integer.MAX_VALUE) ? 0 : sum - n1;
            int op2 = (m1 == Integer.MAX_VALUE || m2 == Integer.MAX_VALUE) ? 0 : sum - (m1 + m2);
            ans = Math.max(op1, op2);
        }

        return ans;
    }
}
