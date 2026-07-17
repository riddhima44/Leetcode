// Last updated: 7/17/2026, 4:20:44 PM
1class Solution {
2    public int[] gcdValues(int[] nums, long[] queries) {
3        int max = 0;
4        for (int x : nums) max = Math.max(max, x);
5
6        int[] freq = new int[max + 1];
7        for (int x : nums) freq[x]++;
8
9        long[] divisible = new long[max + 1];
10
11        // count numbers divisible by i
12        for (int i = 1; i <= max; i++) {
13            for (int j = i; j <= max; j += i) {
14                divisible[i] += freq[j];
15            }
16        }
17
18        long[] exact = new long[max + 1];
19
20        // inclusion-exclusion
21        for (int i = max; i >= 1; i--) {
22            long pairs = divisible[i] * (divisible[i] - 1) / 2;
23
24            for (int j = i + i; j <= max; j += i) {
25                pairs -= exact[j];
26            }
27
28            exact[i] = pairs;
29        }
30
31        // prefix counts
32        long[] prefix = new long[max + 1];
33        for (int i = 1; i <= max; i++) {
34            prefix[i] = prefix[i - 1] + exact[i];
35        }
36
37        int[] ans = new int[queries.length];
38
39        for (int i = 0; i < queries.length; i++) {
40            long target = queries[i] + 1; // prefix is 1-based
41
42            int l = 1, r = max;
43            while (l < r) {
44                int mid = (l + r) / 2;
45                if (prefix[mid] >= target)
46                    r = mid;
47                else
48                    l = mid + 1;
49            }
50
51            ans[i] = l;
52        }
53
54        return ans;
55    }
56}