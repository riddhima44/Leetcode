// Last updated: 1/19/2026, 10:47:41 PM
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans = 0;

    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return ans;
    }

    private void dfs(TreeNode node, int minSoFar, int maxSoFar) {
        if (node == null) return;

        int curr = node.val;

        ans = Math.max(ans, Math.max(
                Math.abs(curr - minSoFar),
                Math.abs(curr - maxSoFar)
        ));

        minSoFar = Math.min(minSoFar, curr);
        maxSoFar = Math.max(maxSoFar, curr);

        dfs(node.left, minSoFar, maxSoFar);
        dfs(node.right, minSoFar, maxSoFar);
    }
}
