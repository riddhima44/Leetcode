// Last updated: 1/19/2026, 9:57:40 PM
class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length - 2;
        int[] freq = new int[n];
        int[] res = new int[2];
        int idx = 0;

        for (int x : nums) {
            freq[x]++;
            if (freq[x] == 2) {
                res[idx++] = x;
                if (idx == 2) break;
            }
        }
        return res;
    }
}
