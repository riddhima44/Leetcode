// Last updated: 1/19/2026, 10:44:59 PM
class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {

        int minLen = Math.min(s1.length(), Math.min(s2.length(), s3.length()));
        int common = 0;

        
        while (common < minLen &&
               s1.charAt(common) == s2.charAt(common) &&
               s2.charAt(common) == s3.charAt(common)) {
            common++;
        }

        if (common == 0) return -1;

        return (s1.length() - common)
             + (s2.length() - common)
             + (s3.length() - common);
    }
}
