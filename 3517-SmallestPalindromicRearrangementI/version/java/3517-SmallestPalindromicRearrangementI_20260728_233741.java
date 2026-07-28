// Last updated: 7/28/2026, 11:37:41 PM
1class Solution {
2    public String smallestPalindrome(String s) {
3        int[] freq = new int[26];
4
5        for (char ch : s.toCharArray()) {
6            freq[ch - 'a']++;
7        }
8
9        StringBuilder firstHalf = new StringBuilder();
10        char middle = 0;
11
12        for (int i = 0; i < 26; i++) {
13            for (int j = 0; j < freq[i] / 2; j++) {
14                firstHalf.append((char) ('a' + i));
15            }
16
17            if ((freq[i] & 1) == 1) {
18                middle = (char) ('a' + i);
19            }
20        }
21
22        StringBuilder ans = new StringBuilder();
23        ans.append(firstHalf);
24
25        if (middle != 0) {
26            ans.append(middle);
27        }
28
29        ans.append(new StringBuilder(firstHalf).reverse());
30
31        return ans.toString();
32    }
33}