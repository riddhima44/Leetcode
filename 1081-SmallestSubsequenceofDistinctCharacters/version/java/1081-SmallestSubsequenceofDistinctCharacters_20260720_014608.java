// Last updated: 7/20/2026, 1:46:08 AM
1class Solution {
2    public String smallestSubsequence(String s) {
3
4        int[] last = new int[26];
5
6        for (int i = 0; i < s.length(); i++) {
7            last[s.charAt(i) - 'a'] = i;
8        }
9
10        boolean[] visited = new boolean[26];
11        StringBuilder stack = new StringBuilder();
12
13        for (int i = 0; i < s.length(); i++) {
14
15            char ch = s.charAt(i);
16
17            if (visited[ch - 'a']) {
18                continue;
19            }
20
21            while (stack.length() > 0 &&
22                   stack.charAt(stack.length() - 1) > ch &&
23                   last[stack.charAt(stack.length() - 1) - 'a'] > i) {
24
25                visited[stack.charAt(stack.length() - 1) - 'a'] = false;
26                stack.deleteCharAt(stack.length() - 1);
27            }
28
29            stack.append(ch);
30            visited[ch - 'a'] = true;
31        }
32
33        return stack.toString();
34    }
35}