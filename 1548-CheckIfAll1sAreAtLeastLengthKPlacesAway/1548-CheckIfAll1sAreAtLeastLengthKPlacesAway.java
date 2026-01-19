// Last updated: 1/19/2026, 10:46:57 PM

class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int prev = -1;  // index of last 1

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (prev != -1 && i - prev - 1 < k) {
                    return false;
                }
                prev = i;
            }
        }

        return true;
    }
}
