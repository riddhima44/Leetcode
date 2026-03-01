// Last updated: 3/1/2026, 1:53:07 PM
1class Solution {
2    public int minPartitions(String n) {
3        int maxDigit = 0;
4
5        for(char c : n.toCharArray()){
6            maxDigit = Math.max(maxDigit, c - '0');
7        }
8
9        return maxDigit;
10    }
11}