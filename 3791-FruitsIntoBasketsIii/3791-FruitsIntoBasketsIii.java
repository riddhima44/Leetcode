// Last updated: 1/19/2026, 9:57:05 PM
class Solution {

    int[] seg;   // segment tree storing max capacity

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = baskets.length;
        seg = new int[4 * n];

        build(0, 0, n - 1, baskets);

        int unplaced = 0;

        for (int fruit : fruits) {
            int idx = findLeftmost(0, 0, n - 1, fruit);
            if (idx == -1) {
                unplaced++;
            } else {
                update(0, 0, n - 1, idx, 0); // basket used
            }
        }
        return unplaced;
    }

    // Build segment tree
    void build(int node, int l, int r, int[] baskets) {
        if (l == r) {
            seg[node] = baskets[l];
            return;
        }
        int mid = (l + r) / 2;
        build(2 * node + 1, l, mid, baskets);
        build(2 * node + 2, mid + 1, r, baskets);
        seg[node] = Math.max(seg[2 * node + 1], seg[2 * node + 2]);
    }

    // Find leftmost index with capacity >= val
    int findLeftmost(int node, int l, int r, int val) {
        if (seg[node] < val) return -1;
        if (l == r) return l;

        int mid = (l + r) / 2;
        int left = findLeftmost(2 * node + 1, l, mid, val);
        if (left != -1) return left;
        return findLeftmost(2 * node + 2, mid + 1, r, val);
    }

    // Update basket capacity after use
    void update(int node, int l, int r, int idx, int val) {
        if (l == r) {
            seg[node] = val;
            return;
        }
        int mid = (l + r) / 2;
        if (idx <= mid)
            update(2 * node + 1, l, mid, idx, val);
        else
            update(2 * node + 2, mid + 1, r, idx, val);

        seg[node] = Math.max(seg[2 * node + 1], seg[2 * node + 2]);
    }
}
