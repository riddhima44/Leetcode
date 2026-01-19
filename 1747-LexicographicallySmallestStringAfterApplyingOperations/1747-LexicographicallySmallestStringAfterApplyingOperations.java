// Last updated: 1/19/2026, 10:46:35 PM
import java.util.*;

class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        String answer = s;
        queue.offer(s);
        visited.add(s);

        while (!queue.isEmpty()) {
            String curr = queue.poll();

            // Track minimum
            if (curr.compareTo(answer) < 0) {
                answer = curr;
            }

            // Operation 1: Add 'a' to odd indices
            char[] arr = curr.toCharArray();
            for (int i = 1; i < arr.length; i += 2) {
                int digit = (arr[i] - '0' + a) % 10;
                arr[i] = (char) ('0' + digit);
            }
            String added = new String(arr);

            if (visited.add(added)) {
                queue.offer(added);
            }

            // Operation 2: Rotate right by b
            String rotated = curr.substring(curr.length() - b) + 
                             curr.substring(0, curr.length() - b);

            if (visited.add(rotated)) {
                queue.offer(rotated);
            }
        }

        return answer;
    }
}
