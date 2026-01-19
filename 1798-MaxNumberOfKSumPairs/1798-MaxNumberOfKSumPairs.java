// Last updated: 1/19/2026, 10:46:25 PM
import java.util.*;

class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int count = 0;

        for (int num : nums) {
            int need = k - num;

            if (freq.getOrDefault(need, 0) > 0) {
                count++;
                freq.put(need, freq.get(need) - 1);
            } else {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }
        }

        return count;
    }
}

