// Last updated: 6/11/2026, 10:00:26 PM
1class Solution {
2    public boolean canReach(int[] arr, int start) {
3
4        int n = arr.length;
5
6        Queue<Integer> q = new LinkedList<>();
7        boolean[] vis = new boolean[n];
8
9        q.offer(start);
10        vis[start] = true;
11
12        while (!q.isEmpty()) {
13
14            int idx = q.poll();
15
16            if (arr[idx] == 0)
17                return true;
18
19            int right = idx + arr[idx];
20            int left = idx - arr[idx];
21
22            if (right < n && !vis[right]) {
23                vis[right] = true;
24                q.offer(right);
25            }
26
27            if (left >= 0 && !vis[left]) {
28                vis[left] = true;
29                q.offer(left);
30            }
31        }
32
33        return false;
34    }
35}