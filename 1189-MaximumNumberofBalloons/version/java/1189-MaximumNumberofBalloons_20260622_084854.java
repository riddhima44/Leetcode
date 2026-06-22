// Last updated: 6/22/2026, 8:48:54 AM
1class Solution {
2    public int maxNumberOfBalloons(String text) {
3        int[] freq = new int[26];
4
5        for (char ch : text.toCharArray()) {
6            freq[ch - 'a']++;
7        }
8
9        return Math.min(
10                Math.min(freq['b' - 'a'], freq['a' - 'a']),
11                Math.min(
12                        Math.min(freq['l' - 'a'] / 2, freq['o' - 'a'] / 2),
13                        freq['n' - 'a']
14                )
15        );
16    }
17}