// Last updated: 5/16/2026, 1:33:31 AM
1class Solution {
2    public int findMin(int[] nums) {
3        int start=0;
4        int end=nums.length-1;
5        int min =Integer.MAX_VALUE;
6        while(start<=end){
7            int mid=start + (end-start)/2;
8            //if the entire search space is sorted 
9            //then arr[low] will be smaller among them
10            if(nums[start]<=nums[end]){
11                min = Math.min(min,nums[start]);
12                return min;
13            }
14            //left sorted array
15            if(nums[mid]>=nums[start]){
16                min = Math.min(min,nums[start]);
17                start=mid+1;
18            }
19            //right sorted array
20            else if(nums[end]>=nums[mid]){
21                min = Math.min(min,nums[mid]);
22                end=mid-1;
23            }
24        }
25        return min;
26    }
27}
28