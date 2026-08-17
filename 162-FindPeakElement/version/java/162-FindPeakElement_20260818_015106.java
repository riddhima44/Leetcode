// Last updated: 8/18/2026, 1:51:06 AM
1class Solution {
2    public int findPeakElement(int[] nums) {
3        if(nums.length==1) return 0;
4        if(nums[0]>nums[1]) return 0;
5        if(nums[nums.length-1]>nums[nums.length-2]) return nums.length-1;
6        int low=1;
7        int high=nums.length-2;
8        while(low<=high){
9            int mid=low+(high-low)/2;
10            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]) return mid;
11            else if(nums[mid]>nums[mid-1]) low=mid+1;
12            else if(nums[mid]>nums[mid+1]) high=mid-1;
13            else low=mid+1;
14        }
15        return -1;
16    }
17}