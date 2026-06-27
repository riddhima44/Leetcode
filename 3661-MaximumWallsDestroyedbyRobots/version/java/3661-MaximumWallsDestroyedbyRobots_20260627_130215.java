// Last updated: 6/27/2026, 1:02:15 PM
1class Solution {
2    public int countMajoritySubarrays(int[] nums, int target) {
3        int n = nums.length;
4        int ans = 0;
5
6        for (int i = 0; i < n; i++) {
7            int countTarget = 0;
8
9            for (int j = i; j < n; j++) {
10                if (nums[j] == target) {
11                    countTarget++;
12                }
13
14                int len = j - i + 1;
15
16                if (countTarget > len / 2) {
17                    ans++;
18                }
19            }
20        }
21
22        return ans;
23    }
24}