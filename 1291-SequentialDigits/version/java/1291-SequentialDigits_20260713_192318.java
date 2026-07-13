// Last updated: 7/13/2026, 7:23:18 PM
1class Solution {
2    public List<Integer> sequentialDigits(int low, int high) {
3        List<Integer> ans = new ArrayList<>();
4
5        for (int len = 2; len <= 9; len++) {
6
7            for (int start = 1; start <= 10 - len; start++) {
8
9                int num = 0;
10                int digit = start;
11
12                for (int i = 0; i < len; i++) {
13                    num = num * 10 + digit;
14                    digit++;
15                }
16
17                if (num >= low && num <= high) {
18                    ans.add(num);
19                }
20            }
21        }
22
23        return ans;
24    }
25}