// Last updated: 3/8/2026, 9:56:00 PM
1class Solution {
2    public String findDifferentBinaryString(String[] nums) {
3        StringBuilder ans = new StringBuilder();
4        
5        for(int i = 0; i < nums.length; i++){
6            char c = nums[i].charAt(i);
7            if(c == '0') ans.append('1');
8            else ans.append('0');
9        }
10        
11        return ans.toString();
12    }
13}