// Last updated: 1/19/2026, 10:45:22 PM
class Solution {
    public int mostBooked(int n, int[][] meetings) {

        // Sort meetings by start time
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        // Min-heap for available rooms
        PriorityQueue<Integer> available = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            available.offer(i);
        }

        // Min-heap for busy rooms: [endTime, room]
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> a[0] == b[0] ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0])
        );

        int[] count = new int[n];

        for (int[] meet : meetings) {
            long start = meet[0];
            long end = meet[1];
            long duration = end - start;

            // Free rooms that are done before current start
            while (!busy.isEmpty() && busy.peek()[0] <= start) {
                available.offer((int) busy.poll()[1]);
            }

            if (!available.isEmpty()) {
                // Assign directly
                int room = available.poll();
                count[room]++;
                busy.offer(new long[]{end, room});
            } else {
                // Delay meeting
                long[] earliest = busy.poll();
                long newEnd = earliest[0] + duration;
                int room = (int) earliest[1];
                count[room]++;
                busy.offer(new long[]{newEnd, room});
            }
        }

        // Find room with max meetings
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (count[i] > count[ans]) {
                ans = i;
            }
        }
        return ans;
    }
}
