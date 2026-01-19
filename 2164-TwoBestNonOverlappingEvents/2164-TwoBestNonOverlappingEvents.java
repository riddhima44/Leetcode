// Last updated: 1/19/2026, 10:45:51 PM
class Solution {
    public int maxTwoEvents(int[][] events) {
        // Sort by start time
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        int n = events.length;

        // suffixMax[i] = max value from i to end
        int[] suffixMax = new int[n];
        suffixMax[n - 1] = events[n - 1][2];

        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i + 1], events[i][2]);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int currValue = events[i][2];
            ans = Math.max(ans, currValue); // single event case

            int nextIndex = findNext(events, events[i][1] + 1);
            if (nextIndex < n) {
                ans = Math.max(ans, currValue + suffixMax[nextIndex]);
            }
        }

        return ans;
    }

    // Binary search: first event with start >= target
    private int findNext(int[][] events, int target) {
        int lo = 0, hi = events.length - 1;
        int res = events.length;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (events[mid][0] >= target) {
                res = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return res;
    }
}
