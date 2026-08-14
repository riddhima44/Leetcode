// Last updated: 8/15/2026, 2:05:54 AM
1class Solution {
2    public int findMin(int[] nums) {
3        int low=0;
4        int high=nums.length-1;
5        int min=Integer.MAX_VALUE;
6        while(low<=high){
7            int mid=low+(high-low)/2;
8            if(nums[low]<=nums[mid]){
9                min=Math.min(min,nums[low]);
10                low=mid+1;
11            }
12            else if(nums[mid]<=nums[high]){
13                min=Math.min(min,nums[mid]);
14                high=mid-1;
15            }
16        }
17        return min;
18    }
19}