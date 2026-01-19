// Last updated: 1/19/2026, 10:50:34 PM
class Solution {
    public int romanToInt(String s) {
        int n = s.length();
        int result = 0;

        // Map Roman characters to values
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        for (int i = 0; i < n; i++) {
            int value = map.get(s.charAt(i));

            // Step 1: If next value is larger, subtract current
            if (i + 1 < n && value < map.get(s.charAt(i + 1))) {
                result -= value;
            } else {
                // Step 2: Otherwise, add current
                result += value;
            }
        }

        return result;
    }
}
