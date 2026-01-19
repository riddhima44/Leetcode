// Last updated: 1/19/2026, 10:50:33 PM
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);

            // Compare this character with all other strings
            for (int j = 1; j < strs.length; j++) {
                // If index exceeds OR mismatch occurs
                if (i >= strs[j].length() || strs[j].charAt(i) != ch) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0]; // All characters matched
    }
}
