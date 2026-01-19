// Last updated: 1/19/2026, 10:45:55 PM
class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int negatives = 0;
        long minAbs = Long.MAX_VALUE;

        for (int[] row : matrix) {
            for (int val : row) {
                long abs = Math.abs((long) val);
                sum += abs;
                if (val < 0) negatives++;
                minAbs = Math.min(minAbs, abs);
            }
        }

        // If odd number of negatives, one smallest abs must stay negative
        if (negatives % 2 == 1) {
            sum -= 2 * minAbs;
        }

        return sum;
    }
}
