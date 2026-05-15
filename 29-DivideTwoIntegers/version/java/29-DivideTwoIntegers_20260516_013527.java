// Last updated: 5/16/2026, 1:35:27 AM
1class Solution {
2    public int divide(int dividend, int divisor) {
3        
4        // Edge case for overflow
5        if (dividend == Integer.MIN_VALUE && divisor == -1) {
6            return Integer.MAX_VALUE;
7        }
8
9        // Determine sign
10        boolean negative = (dividend < 0) ^ (divisor < 0);
11
12        // Convert to long to avoid overflow
13        long dvd = Math.abs((long) dividend);
14        long dvs = Math.abs((long) divisor);
15
16        int quotient = 0;
17
18        while (dvd >= dvs) {
19
20            long temp = dvs;
21            int multiple = 1;
22
23            // Double divisor until it exceeds dividend
24            while (dvd >= (temp << 1)) {
25                temp <<= 1;
26                multiple <<= 1;
27            }
28
29            dvd -= temp;
30            quotient += multiple;
31        }
32
33        return negative ? -quotient : quotient;
34    }
35}