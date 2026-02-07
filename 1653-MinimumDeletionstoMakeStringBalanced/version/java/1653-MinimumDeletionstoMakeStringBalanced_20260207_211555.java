// Last updated: 2/7/2026, 9:15:55 PM
1class Solution {
2    public int minimumDeletions(String s) {
3        int bCount=0;
4        int deletions=0;
5        for (char c:s.toCharArray()) {
6            if (c=='b') {
7                bCount++;
8            } else { 
9                deletions = Math.min(deletions+1,bCount);
10            }
11        }
12        return deletions;
13    }
14}