// Last updated: 1/19/2026, 10:46:37 PM
class Solution {
    public int minimumOneBitOperations(int n) {
        int result = 0;
        while (n > 0) {
            result ^= n;
            n >>= 1;
        }
        return result;
    }
}
