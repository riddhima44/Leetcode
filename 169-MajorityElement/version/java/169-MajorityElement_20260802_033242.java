// Last updated: 8/2/2026, 3:32:42 AM
1class Solution {
2    public int majorityElement(int[] arr) {
3        HashMap<Integer, Integer> map = new HashMap<>();
4
5    for (int num : arr) {
6        map.put(num, map.getOrDefault(num, 0) + 1);
7    }
8
9    int n = arr.length;
10
11    for (int key : map.keySet()) {
12        if (map.get(key) > n / 2)
13            return key;
14    }
15
16    return -1;
17    }
18}