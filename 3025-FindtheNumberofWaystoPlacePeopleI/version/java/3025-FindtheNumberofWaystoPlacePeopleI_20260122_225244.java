// Last updated: 1/22/2026, 10:52:44 PM
1import java.util.*;
2
3class Solution {
4    public int triangleNumber(int[] nums) {
5        Arrays.sort(nums);
6        int n = nums.length;
7        int count = 0;
8
9        for (int k = n - 1; k >= 2; k--) {
10            int i = 0, j = k - 1;
11
12            while (i < j) {
13                if (nums[i] + nums[j] > nums[k]) {
14                    count += (j - i);
15                    j--;
16                } else {
17                    i++;
18                }
19            }
20        }
21
22        return count;
23    }
24}
25