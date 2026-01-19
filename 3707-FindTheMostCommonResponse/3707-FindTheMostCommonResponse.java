// Last updated: 1/19/2026, 9:57:17 PM
import java.util.*;

class Solution {
    public String findCommonResponse(List<List<String>> responses) {
        Map<String, Integer> freq = new HashMap<>();

        // Count unique responses per day
        for (List<String> day : responses) {
            Set<String> unique = new HashSet<>(day);
            for (String s : unique) {
                freq.put(s, freq.getOrDefault(s, 0) + 1);
            }
        }

        String ans = "";
        int max = 0;

        // Find most frequent, lexicographically smallest if tie
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            String word = entry.getKey();
            int count = entry.getValue();

            if (count > max || (count == max && word.compareTo(ans) < 0)) {
                max = count;
                ans = word;
            }
        }

        return ans;
    }
}
