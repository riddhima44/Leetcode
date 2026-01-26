// Last updated: 1/26/2026, 11:52:07 PM
1class Solution {
2    public int minDays(int[] bloomDay, int m, int k) {
3        if((long)m*k > bloomDay.length) return -1;
4        int max = Integer.MIN_VALUE;
5        int min = Integer.MAX_VALUE;
6        for(int p:bloomDay){
7            max = Math.max(p,max);
8            min = Math.min(p,min);
9        }
10        int start=min;
11        int end = max;
12        while(start<=end){
13            int mid = start+(end-start)/2;
14            int bouquetcount=fun(bloomDay,mid,m,k);
15            if(bouquetcount>=m){
16                end=mid-1;
17            }
18            else{
19                start=mid+1;
20            }
21        }
22        return start;
23    }
24    public int fun(int[] bloomDay,int day,int m,int k){
25        int bouquetcount=0;
26        int count=0;
27        for(int i=0; i<bloomDay.length;i++){
28            if(bloomDay[i]<=day){
29                count++;   
30            }
31            else{
32                bouquetcount+=count/k;
33                count=0;
34            }
35        }
36        bouquetcount+=count/k;
37        return bouquetcount;
38    }
39}