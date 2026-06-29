// Last updated: 6/29/2026, 1:43:28 PM
1class Solution {
2    public int numOfStrings(String[] patterns, String word) {
3        int count = 0;
4
5        for (String s : patterns) {
6            if (word.contains(s)) {
7                count++;
8            }
9        }
10
11        return count;
12    }
13}