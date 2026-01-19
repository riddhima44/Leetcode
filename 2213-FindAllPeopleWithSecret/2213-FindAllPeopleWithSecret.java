// Last updated: 1/19/2026, 10:45:48 PM
import java.util.*;

public class Solution {

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {

        // Step 1: group meetings by time
        Map<Integer, List<int[]>> byTime = new TreeMap<>();
        for (int[] m : meetings) {
            byTime.computeIfAbsent(m[2], k -> new ArrayList<>())
                  .add(new int[]{m[0], m[1]});
        }

        boolean[] hasSecret = new boolean[n];
        hasSecret[0] = true;
        hasSecret[firstPerson] = true;

        // Step 2: process each time group
        for (int time : byTime.keySet()) {
            List<int[]> list = byTime.get(time);

            // Build temporary graph
            Map<Integer, List<Integer>> graph = new HashMap<>();
            for (int[] m : list) {
                graph.computeIfAbsent(m[0], k -> new ArrayList<>()).add(m[1]);
                graph.computeIfAbsent(m[1], k -> new ArrayList<>()).add(m[0]);
            }

            // BFS starting points: people who already know the secret
            Queue<Integer> q = new ArrayDeque<>();
            Set<Integer> visited = new HashSet<>();

            for (int p : graph.keySet()) {
                if (hasSecret[p]) {
                    q.offer(p);
                    visited.add(p);
                }
            }

            // Spread within same time
            while (!q.isEmpty()) {
                int u = q.poll();
                for (int v : graph.get(u)) {
                    if (!visited.contains(v)) {
                        visited.add(v);
                        q.offer(v);
                    }
                }
            }

            // Commit results
            for (int p : visited) {
                hasSecret[p] = true;
            }
        }

        // Collect answer
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (hasSecret[i]) result.add(i);
        }
        return result;
    }
}
