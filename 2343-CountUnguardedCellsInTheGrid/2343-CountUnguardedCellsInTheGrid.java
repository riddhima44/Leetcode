// Last updated: 1/19/2026, 10:45:35 PM
class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];

        // 1 = guard, 2 = wall, -1 = guarded
        for (int[] g : guards) {
            grid[g[0]][g[1]] = 1;
        }
        for (int[] w : walls) {
            grid[w[0]][w[1]] = 2;
        }

        // Sweep rows: left -> right
        for (int i = 0; i < m; i++) {
            boolean seen = false;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) seen = false;
                else if (grid[i][j] == 1) seen = true;
                else if (seen) grid[i][j] = -1;
            }
        }

        // Sweep rows: right -> left
        for (int i = 0; i < m; i++) {
            boolean seen = false;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 2) seen = false;
                else if (grid[i][j] == 1) seen = true;
                else if (seen) grid[i][j] = -1;
            }
        }

        // Sweep columns: top -> bottom
        for (int j = 0; j < n; j++) {
            boolean seen = false;
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 2) seen = false;
                else if (grid[i][j] == 1) seen = true;
                else if (seen) grid[i][j] = -1;
            }
        }

        // Sweep columns: bottom -> top
        for (int j = 0; j < n; j++) {
            boolean seen = false;
            for (int i = m - 1; i >= 0; i--) {
                if (grid[i][j] == 2) seen = false;
                else if (grid[i][j] == 1) seen = true;
                else if (seen) grid[i][j] = -1;
            }
        }

        // Count unguarded empty cells
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) count++;
            }
        }

        return count;
    }
}
