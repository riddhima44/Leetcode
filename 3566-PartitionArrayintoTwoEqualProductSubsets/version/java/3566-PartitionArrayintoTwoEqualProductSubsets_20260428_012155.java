// Last updated: 4/28/2026, 1:21:55 AM
1class Solution {
2    public int findLatestStep(int[] arr, int m) {
3        int n = arr.length;
4
5        if (m == n) return n;
6
7        int[] length = new int[n + 2]; // boundary lengths
8        int[] count = new int[n + 1];  // count of groups by size
9
10        int res = -1;
11
12        for (int i = 0; i < n; i++) {
13            int pos = arr[i];
14
15            int left = length[pos - 1];
16            int right = length[pos + 1];
17
18            int newLen = left + right + 1;
19
20            // remove old groups
21            if (left > 0) count[left]--;
22            if (right > 0) count[right]--;
23
24            // add new group
25            count[newLen]++;
26
27            // update boundaries
28            length[pos - left] = newLen;
29            length[pos + right] = newLen;
30
31            // check
32            if (count[m] > 0) {
33                res = i + 1;
34            }
35        }
36
37        return res;
38    }
39}