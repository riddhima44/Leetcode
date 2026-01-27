// Last updated: 1/27/2026, 8:25:06 PM
1class Solution {
2    public int smallestDivisor(int[] nums, int threshold) {
3        int max = Integer.MIN_VALUE;
4        for(int i=0;i<nums.length;i++){
5            max = Math.max(max,nums[i]);
6        }
7        int start =1;
8        int end= max;
9        while(start<=end){
10            int mid = start + (end-start)/2;
11            boolean bool = fun(nums,mid,threshold);
12            if(bool){
13                end=mid-1;
14            }
15            else{
16                start=mid+1;
17            }
18        }
19        return start;
20    }
21    public boolean fun(int[] nums, int divisor,int threshold){
22        long sum=0;
23        for(int i=0;i<nums.length;i++){
24            sum += Math.ceil((double)nums[i]/divisor);
25            if(sum>threshold) return false;
26        }
27        return true;
28    }
29}