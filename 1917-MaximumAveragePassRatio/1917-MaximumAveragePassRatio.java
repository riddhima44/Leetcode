// Last updated: 1/19/2026, 10:46:00 PM
import java.util.PriorityQueue;

class Solution {

    static class ClassInfo {
        int pass, total;

        ClassInfo(int p, int t) {
            pass = p;
            total = t;
        }

        double gain() {
            return (double)(total - pass) / (total * (total + 1.0));
        }
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {

        PriorityQueue<ClassInfo> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(b.gain(), a.gain())
        );

        for (int[] c : classes) {
            pq.add(new ClassInfo(c[0], c[1]));
        }

        while (extraStudents-- > 0) {
            ClassInfo cur = pq.poll();
            cur.pass++;
            cur.total++;
            pq.add(cur);
        }

        double sum = 0.0;
        while (!pq.isEmpty()) {
            ClassInfo c = pq.poll();
            sum += (double) c.pass / c.total;
        }

        return sum / classes.length;
    }
}
