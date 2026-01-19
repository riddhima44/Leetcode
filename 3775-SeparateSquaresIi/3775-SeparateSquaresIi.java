// Last updated: 1/19/2026, 9:57:10 PM
import java.util.*;

public class Solution {

    static class Event {
        long y;
        int type; // +1 = add, -1 = remove
        int x1, x2;

        Event(long y, int type, int x1, int x2) {
            this.y = y;
            this.type = type;
            this.x1 = x1;
            this.x2 = x2;
        }
    }

    static class SegmentTree {
        int n;
        int[] count;
        long[] length;
        long[] xs;

        SegmentTree(long[] xs) {
            this.xs = xs;
            this.n = xs.length - 1;
            this.count = new int[4 * n];
            this.length = new long[4 * n];
        }

        void update(int node, int l, int r, int ql, int qr, int val) {
            if (ql >= r || qr <= l) return;

            if (ql <= l && r <= qr) {
                count[node] += val;
            } else {
                int mid = (l + r) / 2;
                update(node * 2, l, mid, ql, qr, val);
                update(node * 2 + 1, mid, r, ql, qr, val);
            }

            if (count[node] > 0) {
                length[node] = xs[r] - xs[l];
            } else if (l + 1 == r) {
                length[node] = 0;
            } else {
                length[node] = length[node * 2] + length[node * 2 + 1];
            }
        }

        long query() {
            return length[1];
        }
    }

    public double separateSquares(int[][] squares) {
        int n = squares.length;
        List<Event> events = new ArrayList<>();
        TreeSet<Long> xSet = new TreeSet<>();

        for (int[] s : squares) {
            long x = s[0], y = s[1], l = s[2];
            xSet.add(x);
            xSet.add(x + l);
        }

        long[] xs = new long[xSet.size()];
        int idx = 0;
        for (long x : xSet) xs[idx++] = x;

        Map<Long, Integer> xIndex = new HashMap<>();
        for (int i = 0; i < xs.length; i++) {
            xIndex.put(xs[i], i);
        }

        for (int[] s : squares) {
            long x = s[0], y = s[1], l = s[2];
            int x1 = xIndex.get(x);
            int x2 = xIndex.get(x + l);

            events.add(new Event(y, +1, x1, x2));
            events.add(new Event(y + l, -1, x1, x2));
        }

        events.sort(Comparator.comparingLong(e -> e.y));

        SegmentTree st = new SegmentTree(xs);

        long totalArea = 0;
        long prevY = events.get(0).y;

        for (Event e : events) {
            long curY = e.y;
            long height = curY - prevY;
            totalArea += st.query() * height;

            st.update(1, 0, st.n, e.x1, e.x2, e.type);
            prevY = curY;
        }

        double half = totalArea / 2.0;
        st = new SegmentTree(xs);

        long areaSoFar = 0;
        prevY = events.get(0).y;

        for (Event e : events) {
            long curY = e.y;
            long height = curY - prevY;
            long width = st.query();
            long slabArea = width * height;

            if (areaSoFar + slabArea >= half) {
                return prevY + (half - areaSoFar) / width;
            }

            areaSoFar += slabArea;
            st.update(1, 0, st.n, e.x1, e.x2, e.type);
            prevY = curY;
        }

        return 0.0; // should never reach here
    }
}
