// Last updated: 1/19/2026, 9:57:09 PM
class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {

        int n = fruits.length;
        boolean[] used = new boolean[n];
        int unplaced = 0;

        for (int fruit : fruits) {
            boolean placed = false;

            // find leftmost available basket that can hold this fruit
            for (int i = 0; i < n; i++) {
                if (!used[i] && baskets[i] >= fruit) {
                    used[i] = true;
                    placed = true;
                    break;
                }
            }

            if (!placed) {
                unplaced++;
            }
        }

        return unplaced;
    }
}
