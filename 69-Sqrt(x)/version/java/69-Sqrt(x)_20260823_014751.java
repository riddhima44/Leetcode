// Last updated: 8/23/2026, 1:47:51 AM
1class Solution {
2    public int mySqrt(int x) {
3        int sqrt=0;
4        for(int i=1;i<=x;i++){
5            if((long)i*i > x){
6                break;
7            }
8            sqrt=i;
9        }
10        return sqrt;
11    }
12}