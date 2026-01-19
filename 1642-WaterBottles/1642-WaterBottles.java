// Last updated: 1/19/2026, 10:46:42 PM
class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int full = numBottles;
        int empty = 0;
        int ans = 0;

        while (full > 0) {
            ans += full;
            empty += full;
            full = empty / numExchange;
            empty = empty % numExchange;
        }

        return ans;
    }
}
