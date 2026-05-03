// Last updated: 5/3/2026, 5:10:16 PM
1class Solution {
2    public boolean rotateString(String s, String goal) {
3        if (s.length() != goal.length()) {
4            return false;
5        }
6        String combined = s + s;
7        return combined.contains(goal);
8    }
9}