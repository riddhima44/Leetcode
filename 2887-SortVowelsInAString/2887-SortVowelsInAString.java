// Last updated: 1/19/2026, 10:45:03 PM
import java.util.*;

class Solution {

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }

    public String sortVowels(String s) {
        List<Character> vowels = new ArrayList<>();

        // Step 1: collect vowels
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                vowels.add(c);
            }
        }

        // Step 2: sort by ASCII
        Collections.sort(vowels);

        // Step 3: rebuild string
        StringBuilder result = new StringBuilder();
        int idx = 0;

        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                result.append(vowels.get(idx++));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}
