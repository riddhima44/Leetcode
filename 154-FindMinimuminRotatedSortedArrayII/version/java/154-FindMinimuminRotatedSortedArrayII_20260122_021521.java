// Last updated: 1/22/2026, 2:15:21 AM
1class Solution {
2    public int findMin(int[] nums) {
3        int start=0;
4        int end=nums.length-1;
5        int min =Integer.MAX_VALUE;
6        while(start<=end){
7            int mid=start + (end-start)/2;
8            if(nums[start]<nums[end]){
9                min = Math.min(min,nums[start]);
10                break;
11            }//notice that equal to sign is removed
12            if(nums[start]==nums[mid] && nums[end]==nums[mid]){
13                min = Math.min(min,nums[mid]);
14                start++;
15                end--;
16            }
17            //left sorted array
18            else if(nums[mid]>=nums[start]){
19                min = Math.min(min,nums[start]);
20                start=mid+1;
21            }
22            //right sorted array
23            else if(nums[end]>=nums[mid]){
24                min = Math.min(min,nums[mid]);
25                end=mid-1;
26            }
27        }
28        return min;
29    }
30}