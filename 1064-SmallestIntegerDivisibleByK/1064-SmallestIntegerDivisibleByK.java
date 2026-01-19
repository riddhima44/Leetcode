// Last updated: 1/19/2026, 10:48:04 PM

class Solution {
    public int smallestRepunitDivByK(int k) {
        // If k is divisible by 2 or 5, no number of all 1s can be divisible by k
        if (k % 2 == 0 || k % 5 == 0) return -1;

        int remainder = 0;

        // Try lengths from 1 to k (pigeonhole principle)
        for (int length = 1; length <= k; length++) {
            remainder = (remainder * 10 + 1) % k;

            if (remainder == 0) {
                return length;  // Found the smallest length
            }
        }

        return -1;  // Safeguard (though this will never execute for valid k)
    }
}
