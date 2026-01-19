// Last updated: 1/19/2026, 10:45:09 PM
class Solution {
    public int countSeniors(String[] details) {
        int c = 0;
        for (String s : details) {
            int age = (s.charAt(11) - '0') * 10 + (s.charAt(12) - '0');
            if (age > 60) c++;
        }
        return c;
    }
}
