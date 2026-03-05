// Last updated: 3/5/2026, 3:15:00 PM
1class Solution {
2    public int minOperations(String s) {
3        int start0 = 0; // mismatches if pattern starts with '0'
4        int start1 = 0; // mismatches if pattern starts with '1'
5        
6        for(int i = 0; i < s.length(); i++){
7            char expected0 = (i % 2 == 0) ? '0' : '1';
8            char expected1 = (i % 2 == 0) ? '1' : '0';
9            
10            if(s.charAt(i) != expected0) start0++;
11            if(s.charAt(i) != expected1) start1++;
12        }
13        
14        return Math.min(start0, start1);
15    }
16}