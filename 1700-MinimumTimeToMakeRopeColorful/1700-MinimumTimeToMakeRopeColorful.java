// Last updated: 1/19/2026, 10:46:39 PM
class Solution {
    public int minCost(String colors, int[] neededTime) {
        int total = 0;
        int maxInGroup = 0;

        for (int i = 0; i < colors.length(); i++) {
            if (i > 0 && colors.charAt(i) != colors.charAt(i - 1)) {
                total -= maxInGroup;   // keep the most expensive one
                maxInGroup = 0;
            }
            total += neededTime[i];
            maxInGroup = Math.max(maxInGroup, neededTime[i]);
        }

        total -= maxInGroup; // last group
        return total;
    }
}
