// Last updated: 3/6/2026, 1:06:10 PM
1class Solution {
2    public boolean checkOnesSegment(String s) {
3        boolean zerofound=false;
4        for(int i=0;i<s.length();i++){
5            if(s.charAt(i)=='0'){
6                zerofound=true;
7            }
8            else if(zerofound && s.charAt(i)=='1'){
9                return false;
10            }
11        }
12        return true;
13    }
14}