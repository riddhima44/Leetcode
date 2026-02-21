// Last updated: 2/21/2026, 11:16:58 PM
1class Solution {
2    public int countPrimeSetBits(int left, int right) {
3        int count = 0;
4        
5        for (int i = left; i <= right; i++) {
6            int bits = Integer.bitCount(i);
7            if (isPrime(bits)) {
8                count++;
9            }
10        }
11        
12        return count;
13    }
14    
15    private boolean isPrime(int n) {
16        if (n < 2) return false;
17        
18        for (int i = 2; i * i <= n; i++) {
19            if (n % i == 0) return false;
20        }
21        
22        return true;
23    }
24}