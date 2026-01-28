// Last updated: 1/28/2026, 10:45:44 PM
1class Solution {
2    public boolean doesAliceWin(String s) {
3        for (char c : s.toCharArray()) {
4            if ("aeiou".indexOf(c) != -1) {
5                return true;
6            }
7        }
8        return false;
9    }
10}
11