// Last updated: 6/30/2026, 1:32:41 PM
1class Solution {
2    public int numberOfSubstrings(String s) {
3        int n = s.length();
4        int[] count = new int[3];
5        int left = 0;
6        int ans = 0;
7
8        for (int right = 0; right < n; right++) {
9            count[s.charAt(right) - 'a']++;
10
11            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
12                ans += n - right;
13                count[s.charAt(left) - 'a']--;
14                left++;
15            }
16        }
17
18        return ans;
19    }
20}