// Last updated: 1/27/2026, 8:14:55 PM
1class Solution {
2    public int smallestDivisor(int[] nums, int threshold) {
3        int max = Integer.MIN_VALUE;
4        for(int i=0;i<nums.length;i++){
5            max = Math.max(max,nums[i]);
6        }
7//1 se chalu kro jiski bhi threshold value match ho jaye whi ans
8        int start =1;
9        int end= max;
10        int ans = -1;
11        while(start<=end){
12            int mid = start + (end-start)/2;
13            boolean bool = fun(nums,mid,threshold);
14            if(bool){
15                ans=mid;
16                end=mid-1;
17            }
18            else{
19                start=mid+1;
20            }
21        }
22        return ans;
23    }
24    public boolean fun(int[] nums, int divisor,int threshold){
25        long sum=0;
26        for(int i=0;i<nums.length;i++){
27            sum += Math.ceil((double)nums[i]/divisor);
28        }
29        if(sum<=threshold){
30            return true;
31        }
32        return false;
33    }
34}