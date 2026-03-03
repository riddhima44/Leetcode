// Last updated: 3/4/2026, 12:16:36 AM
1class Solution {
2    public char findKthBit(int n, int k) {
3        if (n == 1) return '0';
4        
5        int mid = 1 << (n - 1);  // 2^(n-1)
6        
7        if (k == mid) return '1';
8        
9        if (k < mid) {
10            return findKthBit(n - 1, k);
11        } else {
12            char ch = findKthBit(n - 1, (1 << n) - k);
13            return ch == '0' ? '1' : '0';
14        }
15    }
16}