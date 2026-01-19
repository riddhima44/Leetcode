// Last updated: 1/19/2026, 11:04:20 PM
1class Solution {
2
3    // arr1 = prices
4    // arr2 = strategy
5    // n = k
6    public long maxProfit(int[] arr1, int[] arr2, int n) {
7        int len = arr1.length;
8        int k = n;
9        int half = k / 2;
10
11        long baseProfit = 0;
12        long[] orig = new long[len];
13
14        // Original profit contributions
15        for (int i = 0; i < len; i++) {
16            orig[i] = (long) arr2[i] * arr1[i];
17            baseProfit += orig[i];
18        }
19
20        // Prefix sums
21        long[] prefOrig = new long[len + 1];
22        long[] prefPrice = new long[len + 1];
23
24        for (int i = 0; i < len; i++) {
25            prefOrig[i + 1] = prefOrig[i] + orig[i];
26            prefPrice[i + 1] = prefPrice[i] + arr1[i];
27        }
28
29        long bestGain = 0;
30
31        // Try all k-length windows
32        for (int l = 0; l + k <= len; l++) {
33            int mid = l + half;
34            int r = l + k;
35
36            // Left half forced to 0 → lose original profit
37            long leftLoss = prefOrig[mid] - prefOrig[l];
38
39            // Right half forced to 1 → gain prices, lose original
40            long rightOld = prefOrig[r] - prefOrig[mid];
41            long rightNew = prefPrice[r] - prefPrice[mid];
42
43            long gain = -leftLoss + (rightNew - rightOld);
44            bestGain = Math.max(bestGain, gain);
45        }
46
47        return baseProfit + bestGain;
48    }
49}
50
51
52