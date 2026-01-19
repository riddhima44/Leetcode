// Last updated: 1/19/2026, 10:48:40 PM
class Solution {
    Map<String, List<Character>> map = new HashMap<>();

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        // Build mapping
        for (String s : allowed) {
            String key = s.substring(0, 2);
            char top = s.charAt(2);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(top);
        }
        return dfs(bottom);
    }

    private boolean dfs(String bottom) {
        // Base case: reached top
        if (bottom.length() == 1) return true;

        // Generate all possible next rows
        List<String> nextRows = new ArrayList<>();
        buildNextRow(bottom, 0, new StringBuilder(), nextRows);

        // Try each possibility
        for (String next : nextRows) {
            if (dfs(next)) return true;
        }
        return false;
    }

    private void buildNextRow(String bottom, int idx,
                              StringBuilder current,
                              List<String> result) {
        if (idx == bottom.length() - 1) {
            result.add(current.toString());
            return;
        }

        String key = bottom.substring(idx, idx + 2);
        if (!map.containsKey(key)) return;

        for (char c : map.get(key)) {
            current.append(c);
            buildNextRow(bottom, idx + 1, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
