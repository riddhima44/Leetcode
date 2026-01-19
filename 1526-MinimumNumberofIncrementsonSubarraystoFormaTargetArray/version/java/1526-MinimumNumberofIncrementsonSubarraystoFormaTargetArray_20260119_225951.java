// Last updated: 1/19/2026, 10:59:51 PM
1class Solution {
2    public int makeTheIntegerZero(int num1, int num2) {
3        for (int k = 1; k <= 60; k++) {
4            long x = (long) num1 - (long) k * num2;
5
6            if (x < k) continue; // CRITICAL FIX
7
8            if (Long.bitCount(x) <= k) {
9                return k;
10            }
11        }
12        return -1;
13    }
14}
15