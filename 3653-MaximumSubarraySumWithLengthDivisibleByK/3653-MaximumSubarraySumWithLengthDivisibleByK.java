// Last updated: 1/19/2026, 9:57:33 PM

class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] minPref = new long[k];
        
        // Initialize minPref with +infinity
        for (int i = 0; i < k; i++) {
            minPref[i] = Long.MAX_VALUE;
        }
        
        long prefix = 0L;
        long ans = Long.MIN_VALUE;
        
        // prefix[0] = 0 at index 0, remainder 0
        minPref[0] = 0L;
        
        for (int i = 1; i <= n; i++) {
            prefix += nums[i - 1];  // prefix sum up to index i-1
            int rem = i % k;
            
            // If some prefix with same remainder exists
            if (minPref[rem] != Long.MAX_VALUE) {
                long candidate = prefix - minPref[rem];
                ans = Math.max(ans, candidate);
            }
            
            // update smallest prefix sum for this remainder
            minPref[rem] = Math.min(minPref[rem], prefix);
        }
        
        return ans;
    }
}
