// Last updated: 6/7/2026, 7:47:50 PM
1class Solution {
2    public int numberOfSpecialChars(String word) {
3        Set<Character> lower = new HashSet<>();
4        Set<Character> upper = new HashSet<>();
5
6        for (char ch : word.toCharArray()) {
7            if (Character.isLowerCase(ch)) {
8                lower.add(ch);
9            } else {
10                upper.add(ch);
11            }
12        }
13
14        int count = 0;
15
16        for (char ch = 'a'; ch <= 'z'; ch++) {
17            if (lower.contains(ch) && upper.contains(Character.toUpperCase(ch))) {
18                count++;
19            }
20        }
21
22        return count;
23    }
24}