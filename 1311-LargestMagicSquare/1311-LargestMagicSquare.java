// Last updated: 1/19/2026, 10:47:19 PM
class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] row = new int[m][n + 1];
        int[][] col = new int[m + 1][n];
        int[][] diag = new int[m + 1][n + 1];
        int[][] anti = new int[m + 1][n + 1];

        // Prefix sums
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                row[i][j + 1] = row[i][j] + grid[i][j];
                col[i + 1][j] = col[i][j] + grid[i][j];
                diag[i + 1][j + 1] = diag[i][j] + grid[i][j];
                anti[i + 1][j] = anti[i][j + 1] + grid[i][j];
            }
        }

        // Try larger squares first
        for (int k = Math.min(m, n); k >= 2; k--) {
            for (int i = 0; i + k <= m; i++) {
                for (int j = 0; j + k <= n; j++) {
                    if (isMagic(grid, row, col, diag, anti, i, j, k)) {
                        return k;
                    }
                }
            }
        }

        return 1; // 1x1 is always magic
    }

    private boolean isMagic(int[][] grid, int[][] row, int[][] col,
                            int[][] diag, int[][] anti,
                            int r, int c, int k) {

        int target = row[r][c + k] - row[r][c];

        // rows
        for (int i = r; i < r + k; i++) {
            if (row[i][c + k] - row[i][c] != target) return false;
        }

        // columns
        for (int j = c; j < c + k; j++) {
            if (col[r + k][j] - col[r][j] != target) return false;
        }

        // main diagonal
        if (diag[r + k][c + k] - diag[r][c] != target) return false;

        // anti diagonal
        if (anti[r + k][c] - anti[r][c + k] != target) return false;

        return true;
    }
}
