// Last updated: 1/31/2026, 10:41:18 PM
1class Solution {
2    public char nextGreatestLetter(char[] letters, char target) {
3        int left = 0, right = letters.length - 1;
4
5        while (left <= right) {
6            int mid = left + (right - left) / 2;
7
8            if (letters[mid] <= target) {
9                left = mid + 1;
10            } else {
11                right = mid - 1;
12            }
13        }
14
15        // If left goes out of bounds, wrap around
16        return left < letters.length ? letters[left] : letters[0];
17    }
18}