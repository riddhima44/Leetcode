// Last updated: 1/21/2026, 9:52:21 PM
1import java.util.*;
2class Solution {
3    public int[] minBitwiseArray(List<Integer> nums) {
4        int n = nums.size();
5        int[] ans = new int[n];
6        for (int i = 0; i < n; i++) {
7            int num = nums.get(i);
8            if (num == 2) {
9                ans[i] = -1;
10                continue;
11            }
12            int r = 0;
13            int temp = num;
14            while ((temp & 1) == 1) {
15                r++;
16                temp >>= 1;  
17            }
18            int prefix_shifted = (num >> r) << r;
19            int trailing = (r == 1) ? 0 : ((1 << (r - 1)) - 1);
20            ans[i] = prefix_shifted | trailing;
21        }
22        return ans;
23    }
24}