// Last updated: 1/19/2026, 9:56:44 PM
import java.util.*;

class Solution {
    static final long MOD = 1_000_000_007;

    public int countTrapezoids(int[][] points) {
        // Count points on each y-level
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] p : points) {
            map.put(p[1], map.getOrDefault(p[1], 0) + 1);
        }

        // Build array of counts
        int m = map.size();
        long[] cnt = new long[m];
        int k = 0;
        for (int v : map.values()) cnt[k++] = v;

        // Precompute C(cnt[i], 2)
        long[] c2 = new long[m];
        for (int i = 0; i < m; i++) {
            long x = cnt[i];
            if (x >= 2) c2[i] = (x * (x - 1) / 2) % MOD;
        }

        // Instead of O(m^2), use sum of all c2 and formula:
        // total = sum_over_i<j  c2[i] * c2[j]
        //       = ( (sum c2)^2 - sum(c2^2) ) / 2
        long sum = 0, sumSq = 0;
        for (long v : c2) {
            sum = (sum + v) % MOD;
            sumSq = (sumSq + (v * v) % MOD) % MOD;
        }

        // Compute ((sum^2 - sumSq) / 2) % MOD
        long total = (sum * sum) % MOD;
        total = (total - sumSq + MOD) % MOD;

        long inv2 = (MOD + 1) / 2;   // modular inverse of 2 since MOD is prime
        total = (total * inv2) % MOD;

        return (int) total;
    }
}
