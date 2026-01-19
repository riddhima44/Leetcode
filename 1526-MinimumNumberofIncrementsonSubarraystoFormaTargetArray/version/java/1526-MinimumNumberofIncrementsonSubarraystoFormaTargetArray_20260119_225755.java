// Last updated: 1/19/2026, 10:57:55 PM
1class Solution {
2    public int minNumberOperations(int[] target) {
3        int ops = target[0];
4
5        for (int i = 1; i < target.length; i++) {
6            if (target[i] > target[i - 1]) {
7                ops += target[i] - target[i - 1];
8            }
9        }
10
11        return ops;
12    }
13}
14