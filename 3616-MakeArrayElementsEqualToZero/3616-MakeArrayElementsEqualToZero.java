// Last updated: 1/19/2026, 9:57:35 PM
class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) continue;

            // try both directions
            for (int dir : new int[]{-1, 1}) {
                int[] arr = nums.clone();
                int curr = i;
                int d = dir;

                while (curr >= 0 && curr < n) {
                    if (arr[curr] == 0) {
                        curr += d;
                    } else {
                        arr[curr]--;
                        d = -d;
                        curr += d;
                    }
                }

                boolean ok = true;
                for (int x : arr) {
                    if (x != 0) {
                        ok = false;
                        break;
                    }
                }

                if (ok) ans++;
            }
        }
        return ans;
    }
}
