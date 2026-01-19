// Last updated: 1/19/2026, 10:48:06 PM
class Solution {
    public int repeatedNTimes(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (!seen.add(num)) {
                return num;
            }
        }
        return -1; // unreachable by constraints
    }
}

