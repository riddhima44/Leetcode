// Last updated: 6/9/2026, 12:50:19 AM
1import java.util.*;
2
3class Solution {
4
5    private int[] nums;
6    private int n;
7    private long[][] memo;
8
9    public int minCost(int[] nums) {
10        this.nums = nums;
11        this.n = nums.length;
12
13        if (n <= 2) {
14            int mx = 0;
15            for (int x : nums) mx = Math.max(mx, x);
16            return mx;
17        }
18
19        memo = new long[n][n];
20        for (long[] row : memo)
21            Arrays.fill(row, -1);
22
23        return (int) dfs(1, 0);
24    }
25
26    private long dfs(int i, int carry) {
27
28        // only carry remains
29        if (i >= n)
30            return nums[carry];
31
32        // carry + one element remain
33        if (i == n - 1)
34            return Math.max(nums[carry], nums[i]);
35
36        if (memo[i][carry] != -1)
37            return memo[i][carry];
38
39        long ans = Long.MAX_VALUE;
40
41        int a = carry;
42        int b = i;
43        int c = i + 1;
44
45        // remove a,b -> c survives
46        ans = Math.min(ans,
47                Math.max(nums[a], nums[b]) + dfs(i + 2, c));
48
49        // remove a,c -> b survives
50        ans = Math.min(ans,
51                Math.max(nums[a], nums[c]) + dfs(i + 2, b));
52
53        // remove b,c -> a survives
54        ans = Math.min(ans,
55                Math.max(nums[b], nums[c]) + dfs(i + 2, a));
56
57        return memo[i][carry] = ans;
58    }
59}