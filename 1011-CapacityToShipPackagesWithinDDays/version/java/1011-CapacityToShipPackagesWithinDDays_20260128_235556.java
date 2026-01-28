// Last updated: 1/28/2026, 11:55:56 PM
1class Solution {
2    public int shipWithinDays(int[] weights, int days) {
3        int max = Integer.MIN_VALUE;
4        int sum=0;
5        for(int i=0;i<weights.length;i++){
6            sum+=weights[i];
7            max = Math.max(max,weights[i]);
8        }
9        int start =max;
10        int end=sum;
11        while(start<=end){
12            int mid = start +(end-start)/2;
13            boolean bool = noOfDays(mid,weights,days);
14            if(bool){
15                end=mid-1;
16            }
17            else{
18                start=mid+1;
19            }
20        }
21        return start;
22    }
23    public boolean noOfDays(int capacity,int[] weights,int days){
24        int sum1=0;
25        int day=1;
26        for(int i=0;i<weights.length;i++){
27            sum1+=weights[i];
28            if(sum1>capacity){
29                day++;
30                sum1=weights[i];
31            }
32        }
33        if(day<=days){
34            return true;
35        } 
36        return false;
37    }
38}