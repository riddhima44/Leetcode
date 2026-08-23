// Last updated: 8/24/2026, 3:32:02 AM
1class Solution {
2    public int minDays(int[] bloomDay, int m, int k) {
3        if(m*k>bloomDay.length) return -1;
4        int min=Integer.MAX_VALUE;
5        int max = Integer.MIN_VALUE;
6        for(int x :bloomDay){
7            min = Math.min(min,x);
8            max = Math.max(max,x);
9        }
10        int low = min;
11        int high=max;
12        int ans=-1;
13        while(low<=high){
14            int mid = low+(high-low)/2;
15            boolean isTrue = fun(bloomDay,m,k,mid);
16            if(isTrue){
17                ans=mid;
18                high=mid-1;
19            }
20            else{
21                low = mid+1;
22            }
23        }
24        return ans;
25    }
26    boolean fun(int[] bloomDay,int m , int k,int i){
27            int tb=0;
28            int count=0;
29            for(int j=0;j<bloomDay.length;j++){
30                if(bloomDay[j]<=i){
31                    count++;
32                }
33                else if(bloomDay[j]>i){
34                    tb +=count/k;
35                    count=0;
36                }
37            }
38            tb+=count/k;
39            if(tb>=m){
40                return true;
41            }
42            return false;
43    }
44}