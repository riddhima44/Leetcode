// Last updated: 1/19/2026, 10:45:41 PM

class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        for (int b : batteries) sum += b;

        long low = 0;
        long high = sum / n; // maximum possible runtime

        while (low < high) {
            long mid = high - (high - low) / 2; // upper mid
            if (canRun(mid, n, batteries)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private boolean canRun(long time, int n, int[] batteries) {
        long total = 0;
        for (int b : batteries) {
            total += Math.min(b, time);
            if (total >= (long) n * time) return true;
        }
        return total >= (long) n * time;
    }
}
