// Last updated: 1/19/2026, 9:56:57 PM
import java.util.*;

class Solution {
    public int minOperations(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int ops = 0;

        for (int x : nums) {
            while (!stack.isEmpty() && stack.peek() > x) {
                stack.pop();
            }
            if (x == 0) continue;
            if (stack.isEmpty() || stack.peek() < x) {
                stack.push(x);
                ops++;
            }
        }
        return ops;
    }
}
