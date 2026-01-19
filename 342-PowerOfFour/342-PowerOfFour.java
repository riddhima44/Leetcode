// Last updated: 1/19/2026, 10:49:06 PM
class Solution {
    public boolean isPowerOfFour(int n) {
        return n > 0 
            && (n & (n - 1)) == 0 
            && (n & 0x55555555) != 0;
    }
}
