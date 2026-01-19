// Last updated: 1/19/2026, 10:45:57 PM
class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];

        // initialize with -1
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);

        // track first and last occurrences
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if (first[c] == -1) first[c] = i;
            last[c] = i;
        }

        int count = 0;

        // for every possible outer character
        for (int c = 0; c < 26; c++) {
            if (first[c] != -1 && last[c] != -1 && first[c] < last[c]) {

                boolean[] middle = new boolean[26];

                // check between first and last index
                for (int i = first[c] + 1; i < last[c]; i++) {
                    middle[s.charAt(i) - 'a'] = true;
                }

                // count distinct middle characters
                for (boolean m : middle) {
                    if (m) count++;
                }
            }
        }

        return count;
    }
}
