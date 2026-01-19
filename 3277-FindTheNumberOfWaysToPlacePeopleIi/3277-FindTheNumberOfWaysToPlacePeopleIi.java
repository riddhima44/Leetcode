// Last updated: 1/19/2026, 9:57:54 PM
import java.util.*;

class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;

        // Sort by x asc, y desc
        Arrays.sort(points, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(b[1], a[1]);
        });

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int ax = points[i][0];
            int ay = points[i][1];

            List<int[]> candidates = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                if (j == i) continue;

                int bx = points[j][0];
                int by = points[j][1];

                // Bob must be lower-right of Alice
                if (bx >= ax && by <= ay) {
                    candidates.add(points[j]);
                }
            }

            // Sort Bob candidates by x increasing
            candidates.sort(Comparator.comparingInt(p -> p[0]));

            int maxY = Integer.MIN_VALUE;

            for (int[] b : candidates) {
                int by = b[1];

                // valid if no point blocks the rectangle
                if (by > maxY) {
                    ans++;
                    maxY = by;
                }
            }
        }

        return ans;
    }
}
