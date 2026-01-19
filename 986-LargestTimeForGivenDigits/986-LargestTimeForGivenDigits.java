// Last updated: 1/19/2026, 10:48:12 PM
class Solution {
    public String largestTimeFromDigits(int[] arr) {
        String ans = "";
        boolean[] used = new boolean[4];
        int[] p = new int[4];
        int max = -1;

        // generate all 4! permutations
        ans = "";
        max = -1;
        dfs(arr, used, p, 0);

        if (bestHour == -1) return "";
        return String.format("%02d:%02d", bestHour, bestMin);
    }

    int bestHour = -1, bestMin = -1;

    private void dfs(int[] arr, boolean[] used, int[] p, int idx) {
        if (idx == 4) {
            int h = p[0] * 10 + p[1];
            int m = p[2] * 10 + p[3];

            if (h < 24 && m < 60) {
                if (h > bestHour || (h == bestHour && m > bestMin)) {
                    bestHour = h;
                    bestMin = m;
                }
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (!used[i]) {
                used[i] = true;
                p[idx] = arr[i];
                dfs(arr, used, p, idx + 1);
                used[i] = false;
            }
        }
    }
}
