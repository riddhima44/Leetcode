// Last updated: 7/24/2026, 4:06:45 AM
1class Solution {
2    public int missingNumber(int[] nums) {
3        int[] arr = new int[nums.length+1];
4        for(int i=0;i<nums.length;i++){
5            arr[nums[i]]=1;
6        }
7        for(int i=0;i<arr.length;i++){
8            if(arr[i]==0) return i;
9        }
10        return -1;
11
12    }
13}