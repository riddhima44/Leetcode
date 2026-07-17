// Last updated: 7/17/2026, 11:54:57 PM
1class Solution {
2    public int maxIceCream(int[] costs, int coins) {
3
4        int max = 0;
5        for (int cost : costs) {
6            max = Math.max(max, cost);
7        }
8
9        int[] freq = new int[max + 1];
10
11        for (int cost : costs) {
12            freq[cost]++;
13        }
14
15        int ans = 0;
16
17        for (int price = 1; price <= max && coins >= price; price++) {
18
19            if (freq[price] == 0) continue;
20
21            int buy = Math.min(freq[price], coins / price);
22
23            ans += buy;
24            coins -= buy * price;
25        }
26
27        return ans;
28    }
29}