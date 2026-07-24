// Last updated: 7/24/2026, 4:45:30 PM
1class Solution {
2    public int singleNumber(int[] nums) {
3        int count=0;
4        for(int i=0;i<nums.length;i++){
5            int num=nums[i];
6            count=0;
7            for(int j=0;j<nums.length;j++){
8                if(nums[j]==num) count++;
9                
10            }
11            if(count==1) return num;
12        }
13        return -1;
14    }
15}