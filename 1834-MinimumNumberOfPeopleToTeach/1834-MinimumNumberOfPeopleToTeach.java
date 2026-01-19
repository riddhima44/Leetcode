// Last updated: 1/19/2026, 10:46:18 PM

class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length;

        // Store languages per user
        Set<Integer>[] langSet = new HashSet[m];
        for (int i = 0; i < m; i++) {
            langSet[i] = new HashSet<>();
            for (int l : languages[i]) {
                langSet[i].add(l);
            }
        }

        // Users involved in "bad" friendships
        Set<Integer> badUsers = new HashSet<>();

        for (int[] f : friendships) {
            int u = f[0] - 1;
            int v = f[1] - 1;

            boolean ok = false;
            for (int l : langSet[u]) {
                if (langSet[v].contains(l)) {
                    ok = true;
                    break;
                }
            }
            if (!ok) {
                badUsers.add(u);
                badUsers.add(v);
            }
        }

        // If no problematic friendships
        if (badUsers.isEmpty()) return 0;

        int ans = Integer.MAX_VALUE;

        // Try teaching each language
        for (int lang = 1; lang <= n; lang++) {
            int count = 0;
            for (int user : badUsers) {
                if (!langSet[user].contains(lang)) {
                    count++;
                }
            }
            ans = Math.min(ans, count);
        }

        return ans;
    }
}
