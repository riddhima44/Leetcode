// Last updated: 7/4/2026, 7:45:45 PM
1class Solution {
2    public int numberOfSteps(int num) {
3        return helper(num);
4    }
5
6    private int helper(int num) {
7        if (num == 0) {
8            return 0;
9        }
10
11        if (num % 2 == 0) {
12            return 1 + helper(num / 2);
13        }
14
15        return 1 + helper(num - 1);
16    }
17}