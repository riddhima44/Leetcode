// Last updated: 4/28/2026, 10:56:24 PM
1class Solution {
2    public int minOperations(int[][] grid, int x) {
3        List<Integer> list = new ArrayList<>();
4        
5        for (int[] row : grid) {
6            for (int num : row) {
7                list.add(num);
8            }
9        }
10        
11        int base = list.get(0);
12        
13        // Step 1: feasibility check
14        for (int num : list) {
15            if ((num - base) % x != 0) return -1;
16        }
17        
18        // Step 2: sort
19        Collections.sort(list);
20        
21        // Step 3: median
22        int median = list.get(list.size() / 2);
23        
24        // Step 4: count operations
25        int ops = 0;
26        for (int num : list) {
27            ops += Math.abs(num - median) / x;
28        }
29        
30        return ops;
31    }
32}