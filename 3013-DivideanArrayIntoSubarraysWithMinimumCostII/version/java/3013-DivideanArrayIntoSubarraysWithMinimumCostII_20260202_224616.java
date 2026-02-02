// Last updated: 2/2/2026, 10:46:16 PM
1import java.util.*;
2class Solution {
3    public long minimumCost(int[] nums, int k, int dist) {
4        int n = nums.length;
5        long base = nums[0];
6        int L = 1;
7        TreeMap<Integer, Integer> select = new TreeMap<>();
8        TreeMap<Integer, Integer> rest = new TreeMap<>();
9        int sizeSelect = 0;
10        long sumSelect = 0;
11        long ans = Long.MAX_VALUE;
12        for (int R = 1; R < n; ++R) {
13            if (sizeSelect < k - 1) {
14                add(select, nums[R]);
15                sizeSelect++;
16                sumSelect += nums[R];
17            } else {
18                add(rest, nums[R]);
19            }
20            if (sizeSelect == k - 1 && !rest.isEmpty()) {
21                int largestSel = select.lastKey();
22                int smallestRest = rest.firstKey();
23                if (largestSel > smallestRest) {
24                    remove(select, largestSel);
25                    add(rest, largestSel);
26                    sumSelect -= largestSel;
27                    remove(rest, smallestRest);
28                    add(select, smallestRest);
29                    sumSelect += smallestRest;
30                }
31            }
32            while (R - L > dist) {
33                int val = nums[L];
34                if (contains(select, val)) {
35                    remove(select, val);
36                    sizeSelect--;
37                    sumSelect -= val;
38                    if (!rest.isEmpty()) {
39                        int smallestRest = rest.firstKey();
40                        remove(rest, smallestRest);
41                        add(select, smallestRest);
42                        sizeSelect++;
43                        sumSelect += smallestRest;
44                    }
45                } else {
46                    remove(rest, val);
47                }
48                L++;
49            }
50            if (sizeSelect == k - 1) {
51                ans = Math.min(ans, base + sumSelect);
52            }
53        }
54        return ans;
55    }
56    private void add(TreeMap<Integer, Integer> map, int x) {
57        map.put(x, map.getOrDefault(x, 0) + 1);
58    }
59    private void remove(TreeMap<Integer, Integer> map, int x) {
60        int cnt = map.getOrDefault(x, 0);
61        if (cnt == 1) map.remove(x);
62        else if (cnt > 1) map.put(x, cnt - 1);
63    }
64    private boolean contains(TreeMap<Integer, Integer> map, int x) {
65        return map.getOrDefault(x, 0) > 0;
66    }
67}