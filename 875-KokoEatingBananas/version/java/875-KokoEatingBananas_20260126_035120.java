// Last updated: 1/26/2026, 3:51:20 AM
1class Solution {
2    public int minEatingSpeed(int[] piles, int h) {
3        int max = Integer.MIN_VALUE;
4        for(int i=0;i<piles.length;i++){
5            if(max<piles[i]){
6                max = piles[i];
7            }
8        }
9        int start=1;
10        int end = max;
11        int finalk=-1;
12        while(start<=end){
13            int mid = start + (end-start)/2;
14            long anshours=tt(piles,mid);
15            if(anshours<=h){
16                finalk=mid;
17                end=mid-1;
18            }
19            else if(anshours>h){
20                start=mid+1;
21            }
22       }
23       return finalk;
24    }
25    public long tt(int[] piles,int k){
26        long totaltime=0;
27        for(int i = 0;i<piles.length;i++){
28            int rem = piles[i] % k;
29            totaltime += piles[i]/k;
30            if(rem!=0){
31                totaltime++;
32            }
33        }
34        return totaltime;
35    }    
36}