// Last updated: 1/19/2026, 10:48:08 PM
import java.util.*;

class Solution {

    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exact = new HashSet<>();
        Map<String, String> lowerMap = new HashMap<>();
        Map<String, String> vowelMap = new HashMap<>();

        // Build maps in wordlist order
        for (String word : wordlist) {
            exact.add(word);

            String lower = word.toLowerCase();
            lowerMap.putIfAbsent(lower, word);

            String norm = normalize(word);
            vowelMap.putIfAbsent(norm, word);
        }

        String[] ans = new String[queries.length];

        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];

            // 1. Exact match
            if (exact.contains(q)) {
                ans[i] = q;
                continue;
            }

            // 2. Case-insensitive match
            String lower = q.toLowerCase();
            if (lowerMap.containsKey(lower)) {
                ans[i] = lowerMap.get(lower);
                continue;
            }

            // 3. Vowel error match
            String norm = normalize(q);
            if (vowelMap.containsKey(norm)) {
                ans[i] = vowelMap.get(norm);
                continue;
            }

            // 4. No match
            ans[i] = "";
        }

        return ans;
    }

    private String normalize(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toLowerCase().toCharArray()) {
            if (isVowel(c)) sb.append('*');
            else sb.append(c);
        }
        return sb.toString();
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
