// Last updated: 6/27/2026, 1:01:00 PM
1class Solution {
2    public int maximumLength(int[] nums) {
3        HashMap<Long, Integer> freq = new HashMap<>();
4
5        for (int x : nums) {
6            freq.put((long) x, freq.getOrDefault((long) x, 0) + 1);
7        }
8
9        int ans = 1;
10
11        // Handle 1 separately
12        if (freq.containsKey(1L)) {
13            int cnt = freq.get(1L);
14            ans = Math.max(ans, (cnt % 2 == 1) ? cnt : cnt - 1);
15        }
16
17        for (long start : freq.keySet()) {
18            if (start == 1L) continue;
19
20            long cur = start;
21            int pairs = 0;
22
23            while (true) {
24                int cnt = freq.getOrDefault(cur, 0);
25
26                if (cnt < 2) break;
27
28                pairs++;
29
30                long next = cur * cur;
31
32                if (next > 1_000_000_000L || !freq.containsKey(next)) {
33                    ans = Math.max(ans, 2 * pairs - 1);
34                    break;
35                }
36
37                ans = Math.max(ans, 2 * pairs + 1);
38                cur = next;
39            }
40        }
41
42        return ans;
43    }
44}