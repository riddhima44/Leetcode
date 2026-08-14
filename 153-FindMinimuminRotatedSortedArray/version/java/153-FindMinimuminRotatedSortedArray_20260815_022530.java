// Last updated: 8/15/2026, 2:25:30 AM
1class Solution {
2    public int findMin(int[] nums) {
3        int low=0;
4        int high=nums.length-1;
5        int min=Integer.MAX_VALUE;
6        while(low<=high){
7            int mid=low+(high-low)/2;
8            if(nums[low]<=nums[high]){
9                min=Math.min(min,nums[low]);
10                break;
11            }
12            else if(nums[low]<=nums[mid]){
13                min=Math.min(min,nums[low]);
14                low=mid+1;
15            }
16            else if(nums[mid]<=nums[high]){
17                min=Math.min(min,nums[mid]);
18                high=mid-1;
19            }
20        }
21        return min;
22    }
23}