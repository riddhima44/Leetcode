// Last updated: 1/19/2026, 10:48:22 PM
class Solution {
    public int subarrayBitwiseORs(int[] arr) {

        Set<Integer> res = new HashSet<>();
        Set<Integer> curr = new HashSet<>();

        for (int x : arr) {
            Set<Integer> next = new HashSet<>();

            // OR current element with all previous ORs
            for (int val : curr) {
                next.add(val | x);
            }

            // Subarray of length 1
            next.add(x);

            // Add all to result
            res.addAll(next);

            // Move forward
            curr = next;
        }

        return res.size();
    }
}
