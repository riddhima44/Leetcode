// Last updated: 6/20/2026, 7:35:58 PM
1import java.util.*;
2
3class Solution {
4    public int maxBuilding(int n, int[][] restrictions) {
5        List<int[]> list = new ArrayList<>();
6        
7        // add building 1
8        list.add(new int[]{1, 0});
9        
10        // add all restrictions
11        for (int[] r : restrictions) {
12            list.add(r);
13        }
14        
15        // add building n
16        list.add(new int[]{n, n - 1});
17        
18        // sort by id
19        Collections.sort(list, (a, b) -> a[0] - b[0]);
20        
21        int m = list.size();
22        
23        // left to right
24        for (int i = 1; i < m; i++) {
25            int dist = list.get(i)[0] - list.get(i - 1)[0];
26            list.get(i)[1] = Math.min(list.get(i)[1], list.get(i - 1)[1] + dist);
27        }
28        
29        // right to left
30        for (int i = m - 2; i >= 0; i--) {
31            int dist = list.get(i + 1)[0] - list.get(i)[0];
32            list.get(i)[1] = Math.min(list.get(i)[1], list.get(i + 1)[1] + dist);
33        }
34        
35        int res = 0;
36        
37        // calculate max peak
38        for (int i = 1; i < m; i++) {
39            int id1 = list.get(i - 1)[0];
40            int h1 = list.get(i - 1)[1];
41            int id2 = list.get(i)[0];
42            int h2 = list.get(i)[1];
43            
44            int dist = id2 - id1;
45            
46            int peak = (h1 + h2 + dist) / 2;
47            res = Math.max(res, peak);
48        }
49        
50        return res;
51    }
52}