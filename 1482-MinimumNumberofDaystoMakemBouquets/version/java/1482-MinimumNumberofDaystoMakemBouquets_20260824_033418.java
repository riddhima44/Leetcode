// Last updated: 8/24/2026, 3:34:18 AM
1class Solution {
2    public int minDays(int[] bloomDay, int m, int k) {
3        if((long)m*k>bloomDay.length) return -1;
4        int min=Integer.MAX_VALUE;
5        int max = Integer.MIN_VALUE;
6        for(int x :bloomDay){
7            min = Math.min(min,x);
8            max = Math.max(max,x);
9        }
10        int low = min;
11        int high=max;
12        while(low<=high){
13            int mid = low+(high-low)/2;
14            boolean isTrue = fun(bloomDay,m,k,mid);
15            if(isTrue){
16                high=mid-1;
17            }
18            else{
19                low = mid+1;
20            }
21        }
22        return low;
23    }
24    boolean fun(int[] bloomDay,int m , int k,int i){
25            int tb=0;
26            int count=0;
27            for(int j=0;j<bloomDay.length;j++){
28                if(bloomDay[j]<=i){
29                    count++;
30                }
31                else if(bloomDay[j]>i){
32                    tb +=count/k;
33                    count=0;
34                }
35            }
36            tb+=count/k;
37            if(tb>=m){
38                return true;
39            }
40            return false;
41    }
42}