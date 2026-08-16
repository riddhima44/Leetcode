// Last updated: 8/16/2026, 7:35:58 PM
1class Solution {
2    public int singleNonDuplicate(int[] nums) {
3        for(int i=0;i<nums.length;i++){
4            if(nums.length ==1){
5                return nums[0];
6            }
7            else if((i==0 ||nums[i-1]!=nums[i]) && (i==nums.length-1 ||nums[i]!=nums[i+1])){
8                return nums[i];
9            }
10        }
11        return -1;
12    }
13}