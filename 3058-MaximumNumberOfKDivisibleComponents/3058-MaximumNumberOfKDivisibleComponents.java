// Last updated: 1/19/2026, 10:45:04 PM
class Solution {
    private long components;
    private int k;
    private int[] values;
    private List<Integer>[] graph;

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        this.k = k;
        this.values = values;
        this.components = 0;

        // Build adjacency list
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        // Run DFS from root 0
        dfs(0, -1);

        return (int) components;
    }

    private long dfs(int node, int parent) {
        long sum = values[node] % k;

        for (int nei : graph[node]) {
            if (nei == parent) continue;
            long childSum = dfs(nei, node);
            sum = (sum + childSum) % k;
        }

        // If this subtree sum is divisible by k, it's a valid component
        if (sum % k == 0) {
            components++;
            return 0; // cut here, so parent sees no remainder
        }

        return sum; // pass remainder up
    }
}
