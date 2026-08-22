// Last updated: 8/23/2026, 1:49:33 AM
1class Solution {
2    public int mySqrt(int x) {
3        int low = 1;
4        int high = x;
5        if(x==0) return 0;
6        while(low<=high){
7            int mid = low +(high-low)/2;
8            if((long)mid*mid<=x){
9                low = mid+1;
10            }
11            else{
12                high=mid-1;
13            }
14        }
15        return high;
16    }
17}