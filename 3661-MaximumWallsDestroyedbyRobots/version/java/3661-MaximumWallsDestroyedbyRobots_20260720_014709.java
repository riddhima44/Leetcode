// Last updated: 7/20/2026, 1:47:09 AM
1class Solution {
2    public int totalWaviness(int num1, int num2) {
3
4        int total = 0;
5
6        for (int num = num1; num <= num2; num++) {
7
8            char[] digits = String.valueOf(num).toCharArray();
9
10            // Numbers with less than 3 digits have waviness 0
11            if (digits.length < 3) continue;
12
13            for (int i = 1; i < digits.length - 1; i++) {
14
15                if ((digits[i] > digits[i - 1] && digits[i] > digits[i + 1]) ||
16                    (digits[i] < digits[i - 1] && digits[i] < digits[i + 1])) {
17                    total++;
18                }
19            }
20        }
21
22        return total;
23    }
24}