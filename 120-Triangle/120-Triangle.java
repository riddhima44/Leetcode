// Last updated: 1/19/2026, 10:49:41 PM
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];

        dp[0] = triangle.get(0).get(0);

        for (int i = 1; i < n; i++) {
            List<Integer> row = triangle.get(i);

            // last element
            dp[i] = dp[i - 1] + row.get(i);

            // middle elements (right to left!)
            for (int j = i - 1; j > 0; j--) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + row.get(j);
            }

            // first element
            dp[0] = dp[0] + row.get(0);
        }

        int ans = dp[0];
        for (int i = 1; i < n; i++) {
            ans = Math.min(ans, dp[i]);
        }

        return ans;
    }
}
