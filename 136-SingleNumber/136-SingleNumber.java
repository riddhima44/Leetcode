// Last updated: 1/19/2026, 10:49:34 PM
class Solution {
    public int singleNumber(int[] nums) {
        int xor=0;
        for(int i=0;i<nums.length;i++){
            xor = xor^nums[i];
        }
        return xor;
    }
}