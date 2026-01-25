// Last updated: 1/26/2026, 3:57:36 AM
1class Solution {
2    public int minEatingSpeed(int[] piles, int h) {
3        int start=1;
4        int end = 0;
5        for(int p:piles){
6            end = Math.max(end,p);
7        }
8        while(start<=end){
9            int mid = start + (end-start)/2;
10            long anshours=tt(piles,mid);
11            if(anshours<=h){
12                end=mid-1;
13            }
14            else if(anshours>h){
15                start=mid+1;
16            }
17       }
18       return start;
19    }
20    public long tt(int[] piles,int k){
21        long totaltime=0;
22        for(int i = 0;i<piles.length;i++){
23            int rem = piles[i] % k;
24            totaltime += piles[i]/k;
25            if(rem!=0){
26                totaltime++;
27            }
28        }
29        return totaltime;
30    }    
31}