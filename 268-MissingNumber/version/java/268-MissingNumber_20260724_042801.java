// Last updated: 7/24/2026, 4:28:01 AM
1class Solution {
2    public int missingNumber(int[] nums) {
3        int x1=0;
4        int x2=0;
5        for(int i=0;i<nums.length;i++){
6            x2 = x2 ^nums[i];
7            x1=x1^i;
8        }
9        x1=x1^nums.length;
10        return x1^x2;
11
12    }
13}