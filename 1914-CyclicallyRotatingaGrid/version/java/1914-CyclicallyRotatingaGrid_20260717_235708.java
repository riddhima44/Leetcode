// Last updated: 7/17/2026, 11:57:08 PM
1class Solution {
2    public String processStr(String s) {
3        StringBuilder sb = new StringBuilder();
4
5        for (char ch : s.toCharArray()) {
6
7            if (ch >= 'a' && ch <= 'z') {
8                sb.append(ch);
9            }
10            else if (ch == '*') {
11                if (sb.length() > 0) {
12                    sb.deleteCharAt(sb.length() - 1);
13                }
14            }
15            else if (ch == '#') {
16                sb.append(sb.toString());
17            }
18            else { // ch == '%'
19                sb.reverse();
20            }
21        }
22
23        return sb.toString();
24    }
25}