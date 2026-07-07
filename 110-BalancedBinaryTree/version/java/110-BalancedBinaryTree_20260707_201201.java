// Last updated: 7/7/2026, 8:12:01 PM
1class Solution {
2    public int rotatedDigits(int n) {
3        int count = 0;
4
5        for (int i = 1; i <= n; i++) {
6            if (isGood(i)) {
7                count++;
8            }
9        }
10
11        return count;
12    }
13
14    private boolean isGood(int num) {
15        boolean changed = false;
16
17        while (num > 0) {
18            int digit = num % 10;
19
20            if (digit == 3 || digit == 4 || digit == 7) {
21                return false;
22            }
23
24            if (digit == 2 || digit == 5 || digit == 6 || digit == 9) {
25                changed = true;
26            }
27
28            num /= 10;
29        }
30
31        return changed;
32    }
33}