// Last updated: 1/19/2026, 9:57:14 PM
import java.util.*;

class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        Map<Integer, List<Integer>> diag = new HashMap<>();

        // Collect diagonals
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                diag.computeIfAbsent(key, k -> new ArrayList<>()).add(grid[i][j]);
            }
        }

        // Sort each diagonal
        for (int key : diag.keySet()) {
            List<Integer> list = diag.get(key);
            if (key >= 0) {
                list.sort(Collections.reverseOrder()); // non-increasing
            } else {
                Collections.sort(list); // non-decreasing
            }
        }

        // Write back
        Map<Integer, Integer> idx = new HashMap<>();
        for (int key : diag.keySet()) idx.put(key, 0);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                int pos = idx.get(key);
                grid[i][j] = diag.get(key).get(pos);
                idx.put(key, pos + 1);
            }
        }

        return grid;
    }
}
