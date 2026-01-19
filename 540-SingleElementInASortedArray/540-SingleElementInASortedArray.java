// Last updated: 1/19/2026, 10:48:48 PM
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start=1;
        int end=nums.length-2;
        if(nums.length==1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[nums.length-1] != nums[nums.length-2]) return nums[nums.length-1];
        while(start<=end){
            int mid=start + (end-start)/2;
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]){
                return nums[mid];
            }
            if((mid%2==0 && nums[mid] == nums[mid+1]) || (mid%2 !=0 && nums[mid-1]==nums[mid])){
                start = mid+1;//element is on the right half
            }
            else{
                end=mid-1;//elem is on the left half
            }

        }
        return -1;//dummy statement bcz the functions always need to return something and it understands that the return statements inside conditionals might never run

    }
}