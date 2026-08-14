// Last updated: 8/15/2026, 1:17:11 AM
1class Solution {
2    public int search(int[] nums, int target) {
3        int low=0;
4        int high=nums.length-1;
5        while(low<=high){
6            int mid = low +(high-low)/2;
7            if(nums[mid]==target) return mid;
8            if(nums[low]<=nums[mid]){
9                if(nums[low]<=target && nums[mid]>=target){
10                    high=mid-1;
11                }
12                else{
13                    low=mid+1;
14                }
15            }
16            if(nums[mid]<=nums[high]){
17                if(nums[mid]<=target && nums[high]>=target){
18                    low=mid+1;
19                }
20                else{
21                    high=mid-1;
22                }
23            }
24        }
25        return -1;
26
27    }
28}