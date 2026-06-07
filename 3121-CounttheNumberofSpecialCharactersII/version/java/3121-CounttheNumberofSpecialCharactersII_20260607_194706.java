// Last updated: 6/7/2026, 7:47:06 PM
1class Solution {
2    public int numberOfSpecialChars(String word) {
3        int[] lastLower = new int[26];
4        int[] firstUpper = new int[26];
5
6        Arrays.fill(lastLower, -1);
7        Arrays.fill(firstUpper, Integer.MAX_VALUE);
8
9        for (int i = 0; i < word.length(); i++) {
10            char ch = word.charAt(i);
11
12            if (Character.isLowerCase(ch)) {
13                lastLower[ch - 'a'] = i;
14            } else {
15                firstUpper[ch - 'A'] =
16                        Math.min(firstUpper[ch - 'A'], i);
17            }
18        }
19
20        int count = 0;
21
22        for (int i = 0; i < 26; i++) {
23            if (lastLower[i] != -1 &&
24                firstUpper[i] != Integer.MAX_VALUE &&
25                lastLower[i] < firstUpper[i]) {
26                count++;
27            }
28        }
29
30        return count;
31    }
32}