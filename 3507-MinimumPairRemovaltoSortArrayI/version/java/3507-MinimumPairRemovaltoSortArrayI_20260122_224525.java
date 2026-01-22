// Last updated: 1/22/2026, 10:45:25 PM
1import java.util.*;
2class Solution {
3    public int minimumPairRemoval(int[] nums) {
4        List<Integer> arr = new ArrayList<>();
5        for (int num : nums) arr.add(num);
6        int ops = 0;
7        while (true) {
8            boolean nonDec = true;
9            for (int i = 1; i < arr.size(); i++) {
10                if (arr.get(i - 1) > arr.get(i)) {
11                    nonDec = false;
12                    break;
13                }
14            }
15            if (nonDec) return ops;
16            int minSum = Integer.MAX_VALUE;
17            int mergeIdx = -1;
18            for (int i = 0; i + 1 < arr.size(); i++) {
19                int curSum = arr.get(i) + arr.get(i + 1);
20                if (curSum < minSum || (curSum == minSum && i < mergeIdx)) {
21                    minSum = curSum;
22                    mergeIdx = i;
23                }
24            }
25            arr.set(mergeIdx, arr.get(mergeIdx) + arr.get(mergeIdx + 1));
26            arr.remove(mergeIdx + 1);
27            ops++;
28        }
29    }
30}