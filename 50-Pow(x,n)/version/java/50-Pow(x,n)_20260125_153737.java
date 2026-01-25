// Last updated: 1/25/2026, 3:37:37 PM
1class Solution {
2    public double myPow(double x, int n) {
3        double ans=1;
4        long m=n;
5        if (m<0) m = m*-1;
6        while(m!=0){
7            if(m%2 ==1){
8                m--;
9                ans=ans*x;
10            }
11            else{
12                m=m/2;
13                x=x*x;
14            }
15        }
16        if(n<0) return 1.0/ans;
17        return ans;
18    }
19}