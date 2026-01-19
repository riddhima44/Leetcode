// Last updated: 1/19/2026, 9:57:32 PM
class Solution {
    public int smallestNumber(int n) {
        int x = 1;
        while (x < n) {
            x = (x << 1) | 1;
        }
        return x;
    }
}
