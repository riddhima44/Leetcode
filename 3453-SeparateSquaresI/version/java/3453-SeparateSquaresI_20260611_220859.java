// Last updated: 6/11/2026, 10:08:59 PM
1class Solution {
2    public int minMirrorPairDistance(int[] nums) {
3        Map<Integer, Integer> pos = new HashMap<>();
4        int ans = Integer.MAX_VALUE;
5
6        for (int i = 0; i < nums.length; i++) {
7            if (pos.containsKey(nums[i])) {
8                ans = Math.min(ans, i - pos.get(nums[i]));
9            }
10
11            pos.put(reverse(nums[i]), i);
12        }
13
14        return ans == Integer.MAX_VALUE ? -1 : ans;
15    }
16
17    private int reverse(int x) {
18        int rev = 0;
19        while (x > 0) {
20            rev = rev * 10 + x % 10;
21            x /= 10;
22        }
23        return rev;
24    }
25}