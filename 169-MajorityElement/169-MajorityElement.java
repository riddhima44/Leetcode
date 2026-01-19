// Last updated: 1/19/2026, 10:49:26 PM
class Solution {
    public int majorityElement(int[] nums) {
        //brute force soln tc O(n^2) and sc O(1) 
        for(int i=0;i<nums.length;i++){
            int count=0;
            for(int j=0;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    count++;
                }
            }if(count>nums.length/2){
                return nums[i];
            }
        }return -1;

    }
}