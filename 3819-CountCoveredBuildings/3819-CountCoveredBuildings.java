// Last updated: 1/19/2026, 9:57:02 PM
class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        // rowMin[x], rowMax[x] -> min/max y in row x
        // colMin[y], colMax[y] -> min/max x in column y
        int[] rowMin = new int[n + 1];
        int[] rowMax = new int[n + 1];
        int[] colMin = new int[n + 1];
        int[] colMax = new int[n + 1];

        Arrays.fill(rowMin, Integer.MAX_VALUE);
        Arrays.fill(colMin, Integer.MAX_VALUE);
        Arrays.fill(rowMax, Integer.MIN_VALUE);
        Arrays.fill(colMax, Integer.MIN_VALUE);

        for (int[] b : buildings) {
            int x = b[0], y = b[1];
            rowMin[x] = Math.min(rowMin[x], y);
            rowMax[x] = Math.max(rowMax[x], y);
            colMin[y] = Math.min(colMin[y], x);
            colMax[y] = Math.max(colMax[y], x);
        }

        int covered = 0;
        for (int[] b : buildings) {
            int x = b[0], y = b[1];
            if (rowMin[x] < y && rowMax[x] > y && colMin[y] < x && colMax[y] > x) {
                covered++;
            }
        }

        return covered;
    }
}
