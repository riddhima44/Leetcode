// Last updated: 1/19/2026, 9:58:00 PM
class Solution {
    static final long MOD = 1_000_000_007L;

    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        // Add boundary fences
        int[] h = new int[hFences.length + 2];
        int[] v = new int[vFences.length + 2];

        h[0] = 1;
        h[1] = m;
        for (int i = 0; i < hFences.length; i++) {
            h[i + 2] = hFences[i];
        }

        v[0] = 1;
        v[1] = n;
        for (int i = 0; i < vFences.length; i++) {
            v[i + 2] = vFences[i];
        }

        Arrays.sort(h);
        Arrays.sort(v);

        // All possible horizontal distances
        Set<Integer> H = new HashSet<>();
        for (int i = 0; i < h.length; i++) {
            for (int j = i + 1; j < h.length; j++) {
                H.add(h[j] - h[i]);
            }
        }

        // All possible vertical distances
        Set<Integer> V = new HashSet<>();
        for (int i = 0; i < v.length; i++) {
            for (int j = i + 1; j < v.length; j++) {
                V.add(v[j] - v[i]);
            }
        }

        int maxSide = -1;
        for (int d : H) {
            if (V.contains(d)) {
                maxSide = Math.max(maxSide, d);
            }
        }

        if (maxSide == -1) return -1;
        return (int)((1L * maxSide * maxSide) % MOD);
    }
}
