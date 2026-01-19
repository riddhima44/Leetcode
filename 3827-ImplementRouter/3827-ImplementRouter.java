// Last updated: 1/19/2026, 9:57:00 PM
import java.util.*;

class Router {

    private static class Packet {
        int source, destination, timestamp;
        Packet(int s, int d, int t) {
            source = s;
            destination = d;
            timestamp = t;
        }
    }

    private static class PacketKey {
        int s, d, t;
        PacketKey(int s, int d, int t) {
            this.s = s;
            this.d = d;
            this.t = t;
        }
        @Override
        public boolean equals(Object o) {
            if (!(o instanceof PacketKey)) return false;
            PacketKey p = (PacketKey) o;
            return s == p.s && d == p.d && t == p.t;
        }
        @Override
        public int hashCode() {
            return Objects.hash(s, d, t);
        }
    }

    private final int memoryLimit;
    private final Deque<Packet> queue = new ArrayDeque<>();
    private final Set<PacketKey> seen = new HashSet<>();
    private final Map<Integer, ArrayList<Integer>> destMap = new HashMap<>();

    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        PacketKey key = new PacketKey(source, destination, timestamp);
        if (seen.contains(key)) return false;

        Packet packet = new Packet(source, destination, timestamp);
        queue.addLast(packet);
        seen.add(key);
        destMap.computeIfAbsent(destination, k -> new ArrayList<>()).add(timestamp);

        if (queue.size() > memoryLimit) {
            removeOldest();
        }
        return true;
    }

    public int[] forwardPacket() {
        if (queue.isEmpty()) return new int[0];
        Packet p = queue.removeFirst();
        cleanup(p);
        return new int[]{p.source, p.destination, p.timestamp};
    }

    public int getCount(int destination, int startTime, int endTime) {
        ArrayList<Integer> list = destMap.get(destination);
        if (list == null) return 0;

        int left = lowerBound(list, startTime);
        int right = upperBound(list, endTime);
        return right - left;
    }

    private void removeOldest() {
        Packet p = queue.removeFirst();
        cleanup(p);
    }

    private void cleanup(Packet p) {
        seen.remove(new PacketKey(p.source, p.destination, p.timestamp));
        ArrayList<Integer> list = destMap.get(p.destination);
        int idx = lowerBound(list, p.timestamp);
        list.remove(idx);
        if (list.isEmpty()) destMap.remove(p.destination);
    }

    private int lowerBound(ArrayList<Integer> list, int target) {
        int l = 0, r = list.size();
        while (l < r) {
            int m = (l + r) / 2;
            if (list.get(m) >= target) r = m;
            else l = m + 1;
        }
        return l;
    }

    private int upperBound(ArrayList<Integer> list, int target) {
        int l = 0, r = list.size();
        while (l < r) {
            int m = (l + r) / 2;
            if (list.get(m) > target) r = m;
            else l = m + 1;
        }
        return l;
    }
}


/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */