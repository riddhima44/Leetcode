// Last updated: 3/7/2026, 1:18:26 PM
1class Solution {
2    public int minFlips(String s) {
3        int n = s.length();
4        String ss = s + s;
5
6        int diff1 = 0, diff2 = 0;
7        int ans = Integer.MAX_VALUE;
8
9        for (int i = 0; i < ss.length(); i++) {
10
11            char c = ss.charAt(i);
12
13            if (c != (i % 2 == 0 ? '0' : '1')) diff1++;
14            if (c != (i % 2 == 0 ? '1' : '0')) diff2++;
15
16            if (i >= n) {
17                char prev = ss.charAt(i - n);
18
19                if (prev != ((i - n) % 2 == 0 ? '0' : '1')) diff1--;
20                if (prev != ((i - n) % 2 == 0 ? '1' : '0')) diff2--;
21            }
22
23            if (i >= n - 1) {
24                ans = Math.min(ans, Math.min(diff1, diff2));
25            }
26        }
27
28        return ans;
29    }
30}