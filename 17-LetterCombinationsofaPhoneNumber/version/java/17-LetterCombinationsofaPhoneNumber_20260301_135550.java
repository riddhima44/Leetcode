// Last updated: 3/1/2026, 1:55:50 PM
1class Solution {
2
3    public List<String> letterCombinations(String digits) {
4
5        List<String> result = new ArrayList<>();
6        if(digits.length() == 0)
7            return result;
8
9        String[] map = {
10            "", "", "abc", "def", "ghi",
11            "jkl", "mno", "pqrs", "tuv", "wxyz"
12        };
13
14        backtrack(digits, 0, new StringBuilder(), result, map);
15        return result;
16    }
17
18    private void backtrack(String digits, int index,
19                           StringBuilder current,
20                           List<String> result,
21                           String[] map) {
22
23        // base case
24        if(index == digits.length()){
25            result.add(current.toString());
26            return;
27        }
28
29        String letters = map[digits.charAt(index) - '0'];
30
31        for(char ch : letters.toCharArray()){
32            current.append(ch);      // choose
33            backtrack(digits, index+1, current, result, map);
34            current.deleteCharAt(current.length()-1); // undo
35        }
36    }
37}