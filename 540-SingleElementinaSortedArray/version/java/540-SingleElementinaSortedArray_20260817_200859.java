// Last updated: 8/17/2026, 8:08:59 PM
1class Solution {
2    public int singleNonDuplicate(int[] nums) {
3        if(nums.length==1) return nums[0];
4        if(nums[0]!=nums[1]) return nums[0];
5        if(nums[nums.length-1]!=nums[nums.length-2]) return nums[nums.length-1];
6        int low=1;
7        int high=nums.length-2;
8        while(low<=high){
9            int mid=low+(high-low)/2;
10            if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]) return nums[mid];
11            if((mid%2==0 && nums[mid+1] == nums[mid]) || (mid%2!=0 && nums[mid-1] == nums[mid])){
12                low=mid+1;
13            }
14            else{
15                high=mid-1;
16            }
17        }
18        return -1;
19
20    }
21}