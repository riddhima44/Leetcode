// Last updated: 1/19/2026, 10:46:52 PM
class Solution {
    public int[] runningSum(int[] nums) {
        
        for(int i = 1 ; i<nums.length ; i++){
            nums[i] = nums[i-1] + nums[i];

        }
        return nums;
    }
}