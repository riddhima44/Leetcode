// Last updated: 7/31/2026, 12:16:47 AM
1class Solution {
2    public boolean search(int[] nums, int target) {
3        int start=0;
4        int end=nums.length-1;
5        while(start<=end){
6            int mid=start+(end-start)/2;
7            if(nums[mid]==target){
8                return true;
9            }
10            if(nums[mid]==nums[end] && nums[mid]==nums[start]){
11                start++;
12                end--;
13            }
14            else if(nums[mid]<=nums[end]){
15                if((target>nums[mid] && target<=nums[end])) start=mid+1;
16                else end=mid-1;
17            }
18            else {
19                if(target>=nums[start] && target<nums[mid]) end=mid-1;
20                else start=mid+1;
21            }
22        } return false;
23    }
24}