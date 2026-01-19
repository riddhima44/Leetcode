// Last updated: 1/19/2026, 10:49:12 PM
class Solution {
    public int missingNumber(int[] nums) {
        //2nd optimal soln using XOR approach
        int xor1=0;
        int xor2 = 0;
        // for(int i=0;i<=nums.length;i++){
        //     xor1 = xor1^i;
        // }
        for(int i=0;i<nums.length;i++){
            xor1 = xor1^nums[i];
            xor2 = xor2^i;
        }
        xor2 = xor2^nums.length;
        return xor1^xor2;
    }
} 