// Last updated: 1/19/2026, 9:57:57 PM
class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double maxDiag = -1;
        int maxArea = 0;

        for (int[] d : dimensions) {
            int l = d[0], w = d[1];
            double diag = Math.sqrt(l * l + w * w);
            int area = l * w;

            if (diag > maxDiag) {
                maxDiag = diag;
                maxArea = area;
            } else if (diag == maxDiag) {
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }
}
