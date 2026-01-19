// Last updated: 1/19/2026, 9:57:49 PM
class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int full = numBottles;
        int empty = 0;
        int cost = numExchange;
        int drank = 0;

        while (full > 0) {
            // Drink all full bottles
            drank += full;
            empty += full;
            full = 0;

            // Try one exchange
            if (empty >= cost) {
                empty -= cost;
                full = 1;
                cost++;
            }
        }

        return drank;
    }
}
