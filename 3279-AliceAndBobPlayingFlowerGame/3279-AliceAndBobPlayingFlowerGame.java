// Last updated: 1/19/2026, 9:57:53 PM
class Solution {
    public long flowerGame(int n, int m) {
        long oddN = (n + 1L) / 2;
        long evenN = n / 2;

        long oddM = (m + 1L) / 2;
        long evenM = m / 2;

        return oddN * evenM + evenN * oddM;
    }
}
