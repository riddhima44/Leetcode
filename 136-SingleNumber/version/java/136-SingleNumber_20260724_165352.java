// Last updated: 7/24/2026, 4:53:52 PM
1class Solution {
2    public int singleNumber(int[] nums) {
3        int xor=0;
4        for(int x:nums) xor=xor^x;
5        return xor;
6    }
7}