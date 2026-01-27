// Last updated: 1/27/2026, 8:18:16 PM
1class Solution {
2    public int smallestDivisor(int[] nums, int threshold) {
3        int max = Integer.MIN_VALUE;
4        for(int i=0;i<nums.length;i++){
5            max = Math.max(max,nums[i]);
6        }
7        int start =1;
8        int end= max;
9        int ans = -1;
10        while(start<=end){
11            int mid = start + (end-start)/2;
12            boolean bool = fun(nums,mid,threshold);
13            if(bool){
14                ans=mid;
15                end=mid-1;
16            }
17            else{
18                start=mid+1;
19            }
20        }
21        return ans;
22    }
23    public boolean fun(int[] nums, int divisor,int threshold){
24        long sum=0;
25        for(int i=0;i<nums.length;i++){
26            sum += Math.ceil((double)nums[i]/divisor);
27            if(sum>threshold) return false;
28        }
29        return true;
30    }
31}