// Last updated: 2/16/2026, 10:46:27 PM
1public class Solution {
2    public int reverseBits(int n) {
3        int result = 0;
4
5        for (int i = 0; i < 32; i++) {
6            int lastBit = n & 1;      // extract last bit
7            result = result << 1;    // make space in result
8            result = result | lastBit; // add bit
9            n = n >> 1;              // move to next bit
10        }
11
12        return result;
13    }
14}
15