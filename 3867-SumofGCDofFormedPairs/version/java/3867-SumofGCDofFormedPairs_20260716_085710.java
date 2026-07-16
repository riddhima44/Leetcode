// Last updated: 7/16/2026, 8:57:10 AM
1import java.util.Arrays;
2
3class Solution {
4    public long gcdSum(int[] nums) {
5        int n = nums.length;
6        int[] prefixGcd = new int[n];
7
8        int maxSoFar = 0;
9        for (int i = 0; i < n; i++) {
10            maxSoFar = Math.max(maxSoFar, nums[i]);
11            prefixGcd[i] = gcd(nums[i], maxSoFar);
12        }
13
14        Arrays.sort(prefixGcd);
15
16        long ans = 0;
17        int left = 0, right = n - 1;
18
19        while (left < right) {
20            ans += gcd(prefixGcd[left], prefixGcd[right]);
21            left++;
22            right--;
23        }
24
25        return ans;
26    }
27
28    private int gcd(int a, int b) {
29        while (b != 0) {
30            int temp = b;
31            b = a % b;
32            a = temp;
33        }
34        return a;
35    }
36}