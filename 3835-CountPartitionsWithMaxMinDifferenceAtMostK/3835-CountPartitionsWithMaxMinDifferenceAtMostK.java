// Last updated: 1/19/2026, 9:56:54 PM
import java.util.*;

class Solution {
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        long MOD = 1_000_000_007L;

        long[] dp = new long[n + 1];   // dp[i] = ways to partition first i elements
        long[] pref = new long[n + 1]; // pref[i] = (dp[0] + ... + dp[i]) % MOD

        dp[0] = 1;
        pref[0] = 1;

        Deque<Integer> minD = new ArrayDeque<>();
        Deque<Integer> maxD = new ArrayDeque<>();

        int left = 0;

        for (int right = 0; right < n; right++) {
            // maintain min deque
            while (!minD.isEmpty() && nums[minD.peekLast()] > nums[right]) {
                minD.pollLast();
            }
            minD.addLast(right);

            // maintain max deque
            while (!maxD.isEmpty() && nums[maxD.peekLast()] < nums[right]) {
                maxD.pollLast();
            }
            maxD.addLast(right);

            // shrink window until condition max - min <= k holds
            while (!minD.isEmpty() && !maxD.isEmpty() &&
                    nums[maxD.peekFirst()] - nums[minD.peekFirst()] > k) {
                if (minD.peekFirst() == left) minD.pollFirst();
                if (maxD.peekFirst() == left) maxD.pollFirst();
                left++;
            }

            // valid starting indices for segment ending at 'right' are [left .. right]
            // segment is nums[i..right], so previous cut is at i (0..right)
            // => dp[right + 1] = sum(dp[left .. right])
            long ways;
            if (left == 0) {
                ways = pref[right];
            } else {
                ways = (pref[right] - pref[left - 1] + MOD) % MOD;
            }

            dp[right + 1] = ways;
            pref[right + 1] = (pref[right] + dp[right + 1]) % MOD;
        }

        return (int) dp[n];
    }
}
