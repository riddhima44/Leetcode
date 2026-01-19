// Last updated: 1/19/2026, 10:49:32 PM
class Solution {
    public int findMin(int[] nums) {
        int start=0;
        int end=nums.length-1;
        int min =Integer.MAX_VALUE;
        while(start<=end){
            int mid=start + (end-start)/2;
            // if(nums[start]<=nums[end]){
            //     min = Math.min(min,nums[start]);
            //     break;
            // }//this shortcut wont work here
            if(nums[start]==nums[mid] && nums[end]==nums[mid]){
                min = Math.min(min,nums[mid]);
                start++;
                end--;
            }
            //left sorted array
            else if(nums[mid]>=nums[start]){
                min = Math.min(min,nums[start]);
                start=mid+1;
            }
            //right sorted array
            else if(nums[end]>=nums[mid]){
                min = Math.min(min,nums[mid]);
                end=mid-1;
            }
        }
        return min;
    }
}