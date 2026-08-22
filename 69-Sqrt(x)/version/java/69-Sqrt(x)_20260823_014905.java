// Last updated: 8/23/2026, 1:49:05 AM
1class Solution {
2    public int mySqrt(int x) {
3        int low = 1;
4        int high = x;
5        int ans=1;
6        if(x==0) return 0;
7        while(low<=high){
8            int mid = low +(high-low)/2;
9            if((long)mid*mid<=x){
10                ans=mid;
11                low = mid+1;
12            }
13            else{
14                high=mid-1;
15            }
16        }
17        return ans;
18    }
19}