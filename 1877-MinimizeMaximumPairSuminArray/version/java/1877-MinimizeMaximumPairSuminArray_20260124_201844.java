// Last updated: 1/24/2026, 8:18:44 PM
1class Solution {
2    public int minPairSum(int[] nums) {
3        Arrays.sort(nums);
4        
5        int left = 0;
6        int right = nums.length - 1;
7        int maxPairSum = 0;
8        
9        while (left < right) {
10            maxPairSum = Math.max(maxPairSum, nums[left] + nums[right]);
11            left++;
12            right--;
13        }
14        
15        return maxPairSum;
16    }
17}