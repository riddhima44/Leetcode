// Last updated: 6/7/2026, 7:46:23 PM
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
17    public TreeNode createBinaryTree(int[][] descriptions) {
18        HashMap<Integer, TreeNode> map = new HashMap<>();
19        HashSet<Integer> children = new HashSet<>();
20
21        for (int[] d : descriptions) {
22            int parent = d[0];
23            int child = d[1];
24            int isLeft = d[2];
25
26            map.putIfAbsent(parent, new TreeNode(parent));
27            map.putIfAbsent(child, new TreeNode(child));
28
29            TreeNode parentNode = map.get(parent);
30            TreeNode childNode = map.get(child);
31
32            if (isLeft == 1) {
33                parentNode.left = childNode;
34            } else {
35                parentNode.right = childNode;
36            }
37
38            children.add(child);
39        }
40
41        // Find root (node that is never a child)
42        for (int[] d : descriptions) {
43            int parent = d[0];
44            if (!children.contains(parent)) {
45                return map.get(parent);
46            }
47        }
48
49        return null;
50    }
51}