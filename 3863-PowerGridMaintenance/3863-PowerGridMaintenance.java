// Last updated: 1/19/2026, 9:56:52 PM
import java.util.*;

class Solution {

    // Disjoint Set Union (Union-Find)
    static class DSU {
        int[] parent, rank;

        DSU(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            for (int i = 1; i <= n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int a, int b) {
            a = find(a);
            b = find(b);
            if (a == b) return;

            if (rank[a] < rank[b]) parent[a] = b;
            else if (rank[a] > rank[b]) parent[b] = a;
            else {
                parent[b] = a;
                rank[a]++;
            }
        }
    }

    public int[] processQueries(int c, int[][] connections, int[][] queries) {

        // Step 1: Build components using DSU
        DSU dsu = new DSU(c);
        for (int[] e : connections) {
            dsu.union(e[0], e[1]);
        }

        // Step 2: For each component, maintain online stations
        Map<Integer, TreeSet<Integer>> componentMap = new HashMap<>();

        for (int i = 1; i <= c; i++) {
            int root = dsu.find(i);
            componentMap
                .computeIfAbsent(root, k -> new TreeSet<>())
                .add(i);
        }

        List<Integer> answer = new ArrayList<>();

        // Step 3: Process queries
        for (int[] q : queries) {
            int type = q[0];
            int x = q[1];
            int root = dsu.find(x);
            TreeSet<Integer> set = componentMap.get(root);

            if (type == 2) {
                // station goes offline
                set.remove(x);
            } else {
                // maintenance check
                if (set.contains(x)) {
                    answer.add(x);
                } else if (set.isEmpty()) {
                    answer.add(-1);
                } else {
                    answer.add(set.first());
                }
            }
        }

        // Convert to array
        int[] res = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            res[i] = answer.get(i);
        }
        return res;
    }
}
