// Last updated: 2/3/2026, 10:38:41 PM
1class Solution {
2    public boolean isTrionic(int[] nums) {
3        int n = nums.length;
4        if (n < 4) return false;
5
6        int c = 0;                 // 0 = inc, 1 = dec, 2 = inc again
7        boolean hasInc = false;    // first increasing segment exists
8        boolean hasDec = false;    // decreasing segment exists
9
10        for (int i = 1; i < n; i++) {
11
12            // strict condition
13            if (nums[i] == nums[i - 1]) return false;
14
15            if (c == 0) {
16                if (nums[i] > nums[i - 1]) {
17                    hasInc = true;
18                } else {
19                    // can't start decreasing without increasing first
20                    if (!hasInc) return false;
21                    c = 1;
22                    hasDec = true;
23                }
24            }
25            else if (c == 1) {
26                if (nums[i] < nums[i - 1]) {
27                    hasDec = true;
28                } else {
29                    c = 2;
30                }
31            }
32            else {
33                // final phase must strictly increase
34                if (nums[i] < nums[i - 1]) return false;
35            }
36        }
37
38        return c == 2 && hasInc && hasDec;
39    }
40}