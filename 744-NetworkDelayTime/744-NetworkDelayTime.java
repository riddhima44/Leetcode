// Last updated: 1/19/2026, 10:48:42 PM
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Build the graph as an adjacency list
        Map<Integer, List<int[]>> graph = new HashMap<>();
        
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        for (int[] time : times) {
            int u = time[0], v = time[1], w = time[2];
            graph.get(u).add(new int[]{v, w});
        }
        
        // Min-heap priority queue: {time to reach node, node}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, k});
        
        // Store the shortest time to each node
        Map<Integer, Integer> dist = new HashMap<>();
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int time = current[0];
            int node = current[1];
            
            // If the node is already visited, skip
            if (dist.containsKey(node)) continue;
            
            // Record the shortest time to reach this node
            dist.put(node, time);
            
            // Explore neighbors
            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0];
                int edgeWeight = neighbor[1];
                if (!dist.containsKey(nextNode)) {
                    pq.offer(new int[]{time + edgeWeight, nextNode});
                }
            }
        }
        
        // Check if all nodes are reachable
        if (dist.size() == n) {
            int maxTime = 0;
            for (int t : dist.values()) {
                maxTime = Math.max(maxTime, t);
            }
            return maxTime;
        }
        
        return -1;
    }
}
