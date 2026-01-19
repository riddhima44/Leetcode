// Last updated: 1/19/2026, 10:49:43 PM
class Solution {
    public void merge(int[] a, int m, int[] b, int n) {
        int x = m - 1;
        int y = n - 1;
        int z = m + n - 1;

        while (x >= 0 && y >= 0) {
            if (a[x] > b[y]) {
                a[z] = a[x];
                x--;
            } else {
                a[z] = b[y];
                y--;
            }
            z--;
        }

        while (y >= 0) {
            a[z] = b[y];
            y--;
            z--;
        }
    }
}