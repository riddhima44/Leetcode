// Last updated: 8/16/2026, 7:40:20 PM
1class Solution {
2    public int singleNonDuplicate(int[] nums) {
3        for(int i=0;i<nums.length;i++){
4            if(nums.length==1) return nums[0];
5            if((i==0 || nums[i]!=nums[i-1]) && (i==nums.length-1 || nums[i]!=nums[i+1])){
6                return nums[i];
7            }
8        }
9        return -1;
10    }
11}