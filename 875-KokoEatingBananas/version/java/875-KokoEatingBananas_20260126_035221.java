// Last updated: 1/26/2026, 3:52:21 AM
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
11        while(start<=end){
12            int mid = start + (end-start)/2;
13            long anshours=tt(piles,mid);
14            if(anshours<=h){
15                end=mid-1;
16            }
17            else if(anshours>h){
18                start=mid+1;
19            }
20       }
21       return start;
22    }
23    public long tt(int[] piles,int k){
24        long totaltime=0;
25        for(int i = 0;i<piles.length;i++){
26            int rem = piles[i] % k;
27            totaltime += piles[i]/k;
28            if(rem!=0){
29                totaltime++;
30            }
31        }
32        return totaltime;
33    }    
34}