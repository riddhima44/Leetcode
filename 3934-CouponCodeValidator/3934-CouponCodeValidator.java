// Last updated: 1/19/2026, 9:56:41 PM
import java.util.*;

class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {

        // Business line priority (ORDER MATTERS)
        Map<String, Integer> priority = new HashMap<>();
        priority.put("electronics", 0);
        priority.put("grocery", 1);
        priority.put("pharmacy", 2);
        priority.put("restaurant", 3);

        List<String[]> valid = new ArrayList<>();

        for (int i = 0; i < code.length; i++) {

            // Rule 1: must be active
            if (!isActive[i]) continue;

            // Rule 2: valid business line
            if (!priority.containsKey(businessLine[i])) continue;

            // Rule 3: valid code
            if (code[i] == null || code[i].isEmpty()) continue;
            if (!code[i].matches("[A-Za-z0-9_]+")) continue;

            valid.add(new String[]{businessLine[i], code[i]});
        }

        // Custom sorting
        valid.sort((a, b) -> {
            int cmp = priority.get(a[0]) - priority.get(b[0]);
            if (cmp != 0) return cmp;
            return a[1].compareTo(b[1]);
        });

        // Extract only codes
        List<String> result = new ArrayList<>();
        for (String[] v : valid) {
            result.add(v[1]);
        }

        return result;
    }
}
