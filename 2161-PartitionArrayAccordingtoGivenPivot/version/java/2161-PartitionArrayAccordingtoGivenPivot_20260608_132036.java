// Last updated: 6/8/2026, 1:20:36 PM
1class Solution {
2    public int[] pivotArray(int[] nums, int pivot) {
3        List<Integer> smaller = new ArrayList<>();
4        List<Integer> equal = new ArrayList<>();
5        List<Integer> greater = new ArrayList<>();
6
7        for (int num : nums) {
8            if (num < pivot) {
9                smaller.add(num);
10            } else if (num == pivot) {
11                equal.add(num);
12            } else {
13                greater.add(num);
14            }
15        }
16
17        int[] result = new int[nums.length];
18        int idx = 0;
19
20        for (int num : smaller) {
21            result[idx++] = num;
22        }
23        for (int num : equal) {
24            result[idx++] = num;
25        }
26        for (int num : greater) {
27            result[idx++] = num;
28        }
29
30        return result;
31    }
32}