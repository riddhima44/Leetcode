// Last updated: 1/19/2026, 9:56:59 PM
class Solution {
    public int findClosest(int x, int y, int z) {
        int d1 = Math.abs(x - z);
        int d2 = Math.abs(y - z);

        if (d1 < d2) return 1;
        if (d2 < d1) return 2;
        return 0;
    }
}
