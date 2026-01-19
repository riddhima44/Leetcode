// Last updated: 1/19/2026, 9:57:13 PM
class Solution {
    public double separateSquares(int[][] squares) {
        double totalArea = 0;
        double low = Double.MAX_VALUE;
        double high = Double.MIN_VALUE;

        for (int[] s : squares) {
            double y = s[1];
            double l = s[2];
            totalArea += l * l;
            low = Math.min(low, y);
            high = Math.max(high, y + l);
        }

        double target = totalArea / 2.0;

        for (int iter = 0; iter < 80; iter++) { // enough for 1e-6 precision
            double mid = (low + high) / 2.0;
            double areaBelow = 0;

            for (int[] s : squares) {
                double y = s[1];
                double l = s[2];

                if (mid <= y) continue;
                if (mid >= y + l) {
                    areaBelow += l * l;
                } else {
                    areaBelow += (mid - y) * l;
                }
            }

            if (areaBelow < target) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
