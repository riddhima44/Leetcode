// Last updated: 1/24/2026, 8:24:35 PM
1class Solution {
2    public List<Integer> replaceNonCoprimes(int[] nums) {
3        Deque<Long> stack = new ArrayDeque<>();
4
5        for (int num : nums) {
6            long curr = num;
7
8            while (!stack.isEmpty() && gcd(stack.peekLast(), curr) > 1) {
9                curr = lcm(stack.pollLast(), curr);
10            }
11            stack.addLast(curr);
12        }
13
14        List<Integer> result = new ArrayList<>();
15        for (long val : stack) {
16            result.add((int) val);
17        }
18        return result;
19    }
20
21    private long gcd(long a, long b) {
22        while (b != 0) {
23            long t = a % b;
24            a = b;
25            b = t;
26        }
27        return a;
28    }
29
30    private long lcm(long a, long b) {
31        return (a / gcd(a, b)) * b;
32    }
33}
34