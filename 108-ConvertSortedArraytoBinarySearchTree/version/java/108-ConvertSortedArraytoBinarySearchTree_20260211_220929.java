// Last updated: 2/11/2026, 10:09:29 PM
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17
18    public TreeNode sortedArrayToBST(int[] nums) {
19        return build(nums, 0, nums.length - 1);
20    }
21
22    private TreeNode build(int[] nums, int low, int high) {
23
24        // Base case
25        if (low > high) return null;
26
27        // Middle element → root
28        int mid = low + (high - low) / 2;
29
30        TreeNode root = new TreeNode(nums[mid]);
31
32        // Build left subtree
33        root.left = build(nums, low, mid - 1);
34
35        // Build right subtree
36        root.right = build(nums, mid + 1, high);
37
38        return root;
39    }
40}
41