// Last updated: 7/1/2026, 3:19:43 PM
1class Solution {
2    public List<String> twoEditWords(String[] queries, String[] dictionary) {
3        List<String> ans = new ArrayList<>();
4
5        for (String query : queries) {
6            for (String word : dictionary) {
7                if (isValid(query, word)) {
8                    ans.add(query);
9                    break;
10                }
11            }
12        }
13
14        return ans;
15    }
16
17    private boolean isValid(String a, String b) {
18        int diff = 0;
19
20        for (int i = 0; i < a.length(); i++) {
21            if (a.charAt(i) != b.charAt(i)) {
22                diff++;
23                if (diff > 2)
24                    return false;
25            }
26        }
27
28        return true;
29    }
30}