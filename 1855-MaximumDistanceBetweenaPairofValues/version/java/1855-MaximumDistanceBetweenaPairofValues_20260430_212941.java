// Last updated: 4/30/2026, 9:29:41 PM
1class Solution {
2    public int maxDistance(int[] nums1, int[] nums2) {
3        int i = 0, j = 0;
4        int ans = 0;
5
6        while (i < nums1.length && j < nums2.length) {
7            if (nums1[i] <= nums2[j]) {
8                ans = Math.max(ans, j - i);
9                j++;  
10            } else {
11                i++; 
12            }
13        }
14
15        return ans;
16    }
17}