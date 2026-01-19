// Last updated: 1/19/2026, 10:47:03 PM
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
    long totalSum = 0;
    long maxProduct = 0;
    static final int MOD = 1_000_000_007;

    public int maxProduct(TreeNode root) {
        // First DFS: compute total sum
        computeTotalSum(root);

        // Second DFS: compute subtree sums & max product
        computeSubtreeSum(root);

        return (int)(maxProduct % MOD);
    }

    private void computeTotalSum(TreeNode node) {
        if (node == null) return;
        totalSum += node.val;
        computeTotalSum(node.left);
        computeTotalSum(node.right);
    }

    private long computeSubtreeSum(TreeNode node) {
        if (node == null) return 0;

        long left = computeSubtreeSum(node.left);
        long right = computeSubtreeSum(node.right);

        long subtreeSum = left + right + node.val;

        long product = subtreeSum * (totalSum - subtreeSum);
        maxProduct = Math.max(maxProduct, product);

        return subtreeSum;
    }
}
