// Last updated: 1/19/2026, 10:46:48 PM
class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] height = new int[n];
        int result = 0;

        for (int i = 0; i < m; i++) {
            // Build histogram
            for (int j = 0; j < n; j++) {
                height[j] = mat[i][j] == 0 ? 0 : height[j] + 1;
            }

            // Monotonic stack: {height, count}
            java.util.Stack<int[]> stack = new java.util.Stack<>();
            int rowSum = 0;

            for (int j = 0; j < n; j++) {
                int cnt = 1;

                while (!stack.isEmpty() && stack.peek()[0] >= height[j]) {
                    int[] prev = stack.pop();
                    rowSum -= prev[0] * prev[1];
                    cnt += prev[1];
                }

                stack.push(new int[]{height[j], cnt});
                rowSum += height[j] * cnt;
                result += rowSum;
            }
        }
        return result;
    }
}
