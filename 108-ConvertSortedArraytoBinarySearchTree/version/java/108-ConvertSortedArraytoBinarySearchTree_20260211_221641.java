// Last updated: 2/11/2026, 10:16:41 PM
1class Solution {
2
3    public List<Integer> maxScoreIndices(int[] nums) {
4
5        int n = nums.length;
6
7        // Step 1: total ones
8        int totalOnes = 0;
9        for (int x : nums) {
10            if (x == 1) totalOnes++;
11        }
12
13        List<Integer> ans = new ArrayList<>();
14
15        int zerosLeft = 0;
16        int onesRight = totalOnes;
17
18        int maxScore = -1;
19
20        // Step 2: check all division points 0 → n
21        for (int i = 0; i <= n; i++) {
22
23            int score = zerosLeft + onesRight;
24
25            if (score > maxScore) {
26                maxScore = score;
27                ans.clear();
28                ans.add(i);
29            }
30            else if (score == maxScore) {
31                ans.add(i);
32            }
33
34            // Move boundary forward
35            if (i < n) {
36                if (nums[i] == 0) zerosLeft++;
37                else onesRight--;
38            }
39        }
40
41        return ans;
42    }
43}
44