// Last updated: 7/1/2026, 3:22:40 PM
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
17    public List<Integer> largestValues(TreeNode root) {
18        List<Integer> ans = new ArrayList<>();
19
20        if (root == null)
21            return ans;
22
23        Queue<TreeNode> q = new LinkedList<>();
24        q.offer(root);
25
26        while (!q.isEmpty()) {
27            int size = q.size();
28            int max = Integer.MIN_VALUE;
29
30            for (int i = 0; i < size; i++) {
31                TreeNode node = q.poll();
32                max = Math.max(max, node.val);
33
34                if (node.left != null)
35                    q.offer(node.left);
36
37                if (node.right != null)
38                    q.offer(node.right);
39            }
40
41            ans.add(max);
42        }
43
44        return ans;
45    }
46}