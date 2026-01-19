// Last updated: 1/19/2026, 9:57:50 PM
import java.util.*;

class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        
        long nextAvailable = Long.MIN_VALUE;
        
        for (int num : nums) {
            long L = (long) num - k;
            long R = (long) num + k;
            
            long cand = Math.max(L, nextAvailable);
            if (cand <= R) {
                ans++;
                nextAvailable = cand + 1;
            }
        }
        
        return ans;
    }
}
