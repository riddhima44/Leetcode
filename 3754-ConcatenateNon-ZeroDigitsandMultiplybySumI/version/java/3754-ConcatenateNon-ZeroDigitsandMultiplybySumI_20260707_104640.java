// Last updated: 7/7/2026, 10:46:40 AM
1class Solution {
2    public long sumAndMultiply(int n) {
3        if (n == 0) return 0;
4
5        int[] digits = new int[10];
6        int len = 0;
7
8        while (n > 0) {
9            digits[len++] = n % 10;
10            n /= 10;
11        }
12
13        long x = 0;
14        long sum = 0;
15
16        for (int i = len - 1; i >= 0; i--) {
17            if (digits[i] != 0) {
18                x = x * 10 + digits[i];
19                sum += digits[i];
20            }
21        }
22
23        return x * sum;
24    }
25}