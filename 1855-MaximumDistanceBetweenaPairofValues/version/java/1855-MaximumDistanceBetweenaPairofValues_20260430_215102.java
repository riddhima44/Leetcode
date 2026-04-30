// Last updated: 4/30/2026, 9:51:02 PM
1class Solution {
2    public long[] distance(int[] nums) {
3        int n = nums.length;
4        long[] ans = new long[n];
5
6        Map<Integer, List<Integer>> map = new HashMap<>();
7
8        // Step 1: group indices
9        for (int i = 0; i < n; i++) {
10            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
11        }
12
13        // Step 2: process each group
14        for (List<Integer> idx : map.values()) {
15            int size = idx.size();
16
17            long[] prefix = new long[size + 1];
18            for (int i = 0; i < size; i++) {
19                prefix[i + 1] = prefix[i] + idx.get(i);
20            }
21
22            for (int j = 0; j < size; j++) {
23                int i = idx.get(j);
24
25                long left = (long) j * i - prefix[j];
26                long right = (prefix[size] - prefix[j + 1]) - (long)(size - j - 1) * i;
27
28                ans[i] = left + right;
29            }
30        }
31
32        return ans;
33    }
34}