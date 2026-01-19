// Last updated: 1/19/2026, 10:45:25 PM
class Solution {
    public int[] numberOfPairs(int[] nums) {
        //tc : O(n) and sc O(1)
        // If the range of numbers is small and known — like 0 ≤ nums[i] ≤ 100 —
// we can simply make an array of fixed size 101,
// where freq[i] counts how many times i appears.
// ✅ Constant space → O(1) (since 101 is a fixed constant, not dependent on n).
        int freq[] = new int[101];
        for(int num:nums){
            freq[num]++;
        }
        int pair=0;
        int leftover =0;
        for(int f:freq){
            pair +=f/2;
            leftover +=f%2;
        }
        return new int[]{pair,leftover};


    }
}