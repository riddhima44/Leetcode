// Last updated: 1/26/2026, 9:20:12 PM
1class Solution {
2    public List<List<Integer>> minimumAbsDifference(int[] arr) {
3        Arrays.sort(arr);
4
5        int minDiff = Integer.MAX_VALUE;
6        int n = arr.length;
7
8        // Step 1: find minimum difference
9        for (int i = 0; i < n - 1; i++) {
10            minDiff = Math.min(minDiff, arr[i + 1] - arr[i]);
11        }
12
13        // Step 2: collect pairs
14        List<List<Integer>> result = new ArrayList<>();
15        for (int i = 0; i < n - 1; i++) {
16            if (arr[i + 1] - arr[i] == minDiff) {
17                result.add(Arrays.asList(arr[i], arr[i + 1]));
18            }
19        }
20
21        return result;
22    }
23}
24