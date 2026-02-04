// Last updated: 2/4/2026, 10:59:09 PM
1class Solution {
2    public long maxSumTrionic(int[] nums) {
3        int n = nums.length;
4        long ans = Long.MIN_VALUE;
5        for (int i = 0; i < n; i++) {
6            int j = i + 1;
7            long res = 0;
8            while (j < n && nums[j - 1] < nums[j]) {
9                j++;
10            }
11            int p = j - 1;
12            if (p == i) { 
13                continue;
14            }
15            res += nums[p] + nums[p - 1]; 
16            while (j < n && nums[j - 1] > nums[j]) {
17                res += nums[j];
18                j++;
19            }
20            int q = j - 1;
21            if (q == p || q == n - 1 || (j < n && nums[j] <= nums[q])) {
22                i = q;
23                continue;
24            }
25            res += nums[q + 1];
26            long maxSum = 0;
27            long sum = 0;
28            for (int k = q + 2; k < n && nums[k] > nums[k - 1]; k++) {
29                sum += nums[k];
30                maxSum = Math.max(maxSum, sum);
31            }
32            res += maxSum;
33            maxSum = 0;
34            sum = 0;
35            for (int k = p - 2; k >= i; k--) {
36                sum += nums[k];
37                maxSum = Math.max(maxSum, sum);
38            }
39            res += maxSum;
40            ans = Math.max(ans, res);
41            i = q - 1;
42        }
43        return ans;
44    }
45}