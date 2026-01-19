// Last updated: 1/19/2026, 9:56:48 PM
import java.util.*;

class Solution {
    private static final int MOD = 1_000_000_007;

    public int specialTriplets(int[] nums) {
        Map<Integer, Long> leftFreq = new HashMap<>();
        Map<Integer, Long> rightFreq = new HashMap<>();

        // initialize right frequency map
        for (int num : nums) {
            rightFreq.put(num, rightFreq.getOrDefault(num, 0L) + 1);
        }

        long ans = 0;

        for (int j = 0; j < nums.length; j++) {
            int mid = nums[j];

            // current element is no longer on the right
            rightFreq.put(mid, rightFreq.get(mid) - 1);

            int target = mid * 2;

            long leftCount = leftFreq.getOrDefault(target, 0L);
            long rightCount = rightFreq.getOrDefault(target, 0L);

            ans = (ans + leftCount * rightCount) % MOD;

            // add current element to left
            leftFreq.put(mid, leftFreq.getOrDefault(mid, 0L) + 1);
        }

        return (int) ans;
    }
}
