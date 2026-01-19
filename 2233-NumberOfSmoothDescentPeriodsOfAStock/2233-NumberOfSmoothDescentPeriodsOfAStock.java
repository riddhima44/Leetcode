// Last updated: 1/19/2026, 10:45:46 PM
class Solution {
    public long getDescentPeriods(int[] prices) {
        long count = 0;
        long len = 0;

        for (int i = 0; i < prices.length; i++) {
            if (i > 0 && prices[i - 1] - prices[i] == 1) {
                len++;
            } else {
                len = 1;
            }
            count += len;
        }

        return count;
    }
}
