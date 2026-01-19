// Last updated: 1/19/2026, 10:46:05 PM
class Solution {
    public boolean check(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                count++;
            }
        }
        if(count==0){
            return true;
        }
        else if(count==1 && nums[0]>=nums[nums.length-1]){
            return true;
        }
        else{
            return false;
        }
//         After rotation:
//         largest … smallest
// That means:
// last element ≤ first element
    }
}