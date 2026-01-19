// Last updated: 1/19/2026, 9:57:59 PM
class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101]; // constraints: nums[i] <= 100
        
        for (int num : nums) {
            freq[num]++;
        }
        
        int maxFreq = 0;
        for (int f : freq) {
            maxFreq = Math.max(maxFreq, f);
        }
        
        int total = 0;
        for (int f : freq) {
            if (f == maxFreq) {
                total += f;
            }
        }
        
        return total;
    }
}
