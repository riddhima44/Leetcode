// Last updated: 1/19/2026, 10:45:10 PM
class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> freq = new HashMap<>();
        int n = basket1.length;

        int globalMin = Integer.MAX_VALUE;

        for (int x : basket1) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
            globalMin = Math.min(globalMin, x);
        }
        for (int x : basket2) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
            globalMin = Math.min(globalMin, x);
        }

        // Feasibility check
        for (int count : freq.values()) {
            if ((count & 1) == 1) return -1;
        }

        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();

        // Find excess elements
        Map<Integer, Integer> freq1 = new HashMap<>();
        Map<Integer, Integer> freq2 = new HashMap<>();

        for (int x : basket1) freq1.put(x, freq1.getOrDefault(x, 0) + 1);
        for (int x : basket2) freq2.put(x, freq2.getOrDefault(x, 0) + 1);

        for (int key : freq.keySet()) {
            int need = freq.get(key) / 2;
            int c1 = freq1.getOrDefault(key, 0);
            int c2 = freq2.getOrDefault(key, 0);

            if (c1 > need) {
                for (int i = 0; i < c1 - need; i++) A.add(key);
            }
            if (c2 > need) {
                for (int i = 0; i < c2 - need; i++) B.add(key);
            }
        }

        Collections.sort(A);
        Collections.sort(B, Collections.reverseOrder());

        long cost = 0;
        for (int i = 0; i < A.size(); i++) {
            cost += Math.min(
                Math.min(A.get(i), B.get(i)),
                2L * globalMin
            );
        }

        return cost;
    }
}
