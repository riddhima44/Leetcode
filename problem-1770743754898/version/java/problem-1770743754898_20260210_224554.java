// Last updated: 2/10/2026, 10:45:54 PM
1class Solution {
2    public int longestBalanced(int[] nums) {
3        int n = nums.length;
4        int maxLen = 0;
5
6        for (int i = 0; i < n; i++) {
7            HashSet<Integer> evenSet = new HashSet<>();
8            HashSet<Integer> oddSet = new HashSet<>();
9
10            for (int j = i; j < n; j++) {
11                if (nums[j] % 2 == 0) {
12                    evenSet.add(nums[j]);
13                } else {
14                    oddSet.add(nums[j]);
15                }
16
17                if (evenSet.size() == oddSet.size()) {
18                    maxLen = Math.max(maxLen, j - i + 1);
19                }
20            }
21        }
22        return maxLen;
23    }
24}