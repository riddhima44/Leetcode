// Last updated: 6/9/2026, 12:48:21 AM
1import java.util.*;
2
3class Solution {
4
5    List<Integer> nums = new ArrayList<>();
6    List<Character> ops = new ArrayList<>();
7
8    Map<String, Set<Integer>> memo = new HashMap<>();
9
10    public int scoreOfStudents(String s, int[] answers) {
11
12        // Parse expression
13        for (char c : s.toCharArray()) {
14            if (c == '+' || c == '*')
15                ops.add(c);
16            else
17                nums.add(c - '0');
18        }
19
20        int correct = evaluate(s);
21
22        Set<Integer> possible =
23                dfs(0, nums.size() - 1);
24
25        int score = 0;
26
27        for (int ans : answers) {
28            if (ans == correct)
29                score += 5;
30            else if (possible.contains(ans))
31                score += 2;
32        }
33
34        return score;
35    }
36
37    private Set<Integer> dfs(int l, int r) {
38
39        String key = l + "," + r;
40
41        if (memo.containsKey(key))
42            return memo.get(key);
43
44        Set<Integer> res = new HashSet<>();
45
46        if (l == r) {
47            res.add(nums.get(l));
48            memo.put(key, res);
49            return res;
50        }
51
52        for (int i = l; i < r; i++) {
53
54            Set<Integer> left = dfs(l, i);
55            Set<Integer> right = dfs(i + 1, r);
56
57            char op = ops.get(i);
58
59            for (int a : left) {
60                for (int b : right) {
61
62                    int val;
63
64                    if (op == '+')
65                        val = a + b;
66                    else
67                        val = a * b;
68
69                    if (val <= 1000)
70                        res.add(val);
71                }
72            }
73        }
74
75        memo.put(key, res);
76        return res;
77    }
78
79    private int evaluate(String s) {
80
81        Stack<Integer> st = new Stack<>();
82
83        int num = s.charAt(0) - '0';
84        st.push(num);
85
86        for (int i = 1; i < s.length(); i += 2) {
87
88            char op = s.charAt(i);
89            int nxt = s.charAt(i + 1) - '0';
90
91            if (op == '*') {
92                st.push(st.pop() * nxt);
93            } else {
94                st.push(nxt);
95            }
96        }
97
98        int ans = 0;
99        while (!st.isEmpty())
100            ans += st.pop();
101
102        return ans;
103    }
104}