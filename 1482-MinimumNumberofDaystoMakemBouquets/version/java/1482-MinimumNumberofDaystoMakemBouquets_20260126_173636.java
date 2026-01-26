// Last updated: 1/26/2026, 5:36:36 PM
1class Solution {
2    public int minDays(int[] bloomDay, int m, int k) {
3        if(m*k > bloomDay.length) return -1;
4        int max = Integer.MIN_VALUE;
5        int min = Integer.MAX_VALUE;
6        for(int p:bloomDay){
7            max = Math.max(p,max);
8            min = Math.min(p,min);
9        }
10        int start=min;
11        int end = max;
12        int day=-1;
13        while(start<=end){
14            int mid = start+(end-start)/2;
15            int bouquetcount=fun(bloomDay,mid,m,k);
16            if(bouquetcount>=m){
17                day=mid;
18                end=mid-1;
19            }
20            else{
21                start=mid+1;
22            }
23        }
24        return day;
25    }
26    public int fun(int[] bloomDay,int day,int m,int k){
27        int bouquetcount=0;
28        int count=0;
29        for(int i=0; i<bloomDay.length;i++){
30            if(bloomDay[i]<=day){
31                    count++;
32                    if(count==k){
33                        count=0;
34                        bouquetcount++;
35                        if(bouquetcount==m) return bouquetcount;      
36                    }
37            }
38            else{
39                    count=0;
40            }
41        }
42        return bouquetcount;
43    }
44}