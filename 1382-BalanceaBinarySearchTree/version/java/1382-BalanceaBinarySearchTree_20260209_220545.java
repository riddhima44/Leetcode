// Last updated: 2/9/2026, 10:05:45 PM
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
18    private List<Integer> inorder = new ArrayList<>();
19
20    public TreeNode balanceBST(TreeNode root) {
21        // Step 1: Store inorder traversal (sorted values)
22        inorderTraversal(root);
23
24        // Step 2: Build balanced BST from sorted list
25        return buildBST(0, inorder.size() - 1);
26    }
27
28    private void inorderTraversal(TreeNode node) {
29        if (node == null) return;
30
31        inorderTraversal(node.left);
32        inorder.add(node.val);
33        inorderTraversal(node.right);
34    }
35
36    private TreeNode buildBST(int left, int right) {
37        if (left > right) return null;
38
39        int mid = left + (right - left) / 2;
40        TreeNode root = new TreeNode(inorder.get(mid));
41
42        root.left = buildBST(left, mid - 1);
43        root.right = buildBST(mid + 1, right);
44
45        return root;
46    }
47}