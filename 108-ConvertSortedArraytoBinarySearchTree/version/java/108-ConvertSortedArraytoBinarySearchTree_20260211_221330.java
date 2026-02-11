// Last updated: 2/11/2026, 10:13:30 PM
1class Solution {
2
3    public List<List<Integer>> combinationSum3(int k, int n) {
4
5        List<List<Integer>> ans = new ArrayList<>();
6        backtrack(1, k, n, new ArrayList<>(), ans);
7        return ans;
8    }
9
10    private void backtrack(int start, int k, int target,
11                           List<Integer> path,
12                           List<List<Integer>> ans) {
13
14        // ✅ Valid combination found
15        if (path.size() == k && target == 0) {
16            ans.add(new ArrayList<>(path));
17            return;
18        }
19
20        // ❌ Invalid path
21        if (path.size() > k || target < 0) return;
22
23        // Try numbers from current start → 9
24        for (int i = start; i <= 9; i++) {
25
26            path.add(i);                         // choose
27
28            backtrack(i + 1, k, target - i,
29                      path, ans);               // explore
30
31            path.remove(path.size() - 1);       // unchoose
32        }
33    }
34}
35