// Last updated: 4/28/2026, 1:18:26 AM
1class Solution {
2    public List<String> generateParenthesis(int n) {
3        List<String> result = new ArrayList<>();
4        backtrack(result, "", 0, 0, n);
5        return result;
6    }
7
8    private void backtrack(List<String> result, String current, int open, int close, int n) {
9        // base case
10        if (current.length() == 2 * n) {
11            result.add(current);
12            return;
13        }
14
15        // add '(' if possible
16        if (open < n) {
17            backtrack(result, current + "(", open + 1, close, n);
18        }
19
20        // add ')' only if valid
21        if (close < open) {
22            backtrack(result, current + ")", open, close + 1, n);
23        }
24    }
25}