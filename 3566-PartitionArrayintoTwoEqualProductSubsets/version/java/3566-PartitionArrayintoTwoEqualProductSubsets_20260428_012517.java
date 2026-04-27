// Last updated: 4/28/2026, 1:25:17 AM
1import java.util.*;
2
3class Solution {
4    public boolean isTransformable(String s, String t) {
5        List<Queue<Integer>> pos = new ArrayList<>();
6        for (int i = 0; i < 10; i++) {
7            pos.add(new LinkedList<>());
8        }
9
10        // store positions of each digit in s
11        for (int i = 0; i < s.length(); i++) {
12            pos.get(s.charAt(i) - '0').offer(i);
13        }
14
15        // process t
16        for (char c : t.toCharArray()) {
17            int digit = c - '0';
18
19            if (pos.get(digit).isEmpty()) return false;
20
21            int index = pos.get(digit).peek();
22
23            // check smaller digits
24            for (int d = 0; d < digit; d++) {
25                if (!pos.get(d).isEmpty() && pos.get(d).peek() < index) {
26                    return false;
27                }
28            }
29
30            pos.get(digit).poll();
31        }
32
33        return true;
34    }
35}