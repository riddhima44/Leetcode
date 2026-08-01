// Last updated: 8/1/2026, 10:14:17 PM
1class Solution {
2    public void sortColors(int[] arr) {
3        int zeros=0;
4        int ones=0;
5        int twos=0;
6        for(int i=0;i<arr.length;i++){
7            if(arr[i]==0) zeros++;
8            else if(arr[i]==1) ones++;
9            else twos++;
10
11        }
12        for(int i=0;i<arr.length;i++){
13            if(zeros>0){
14                arr[i]=0;
15                zeros--;
16            }
17            else if(ones>0){
18                arr[i]=1;
19                ones--;
20            }
21            else{
22                arr[i]=2;
23            }
24        }
25
26    }
27}