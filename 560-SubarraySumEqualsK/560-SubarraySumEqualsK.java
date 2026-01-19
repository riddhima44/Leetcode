// Last updated: 1/19/2026, 10:48:46 PM
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer , Integer> m=new HashMap<>();
        m.put(0,1);
        int sum=0;
        int ans =0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(m.containsKey(sum - k)){
                ans += m.get(sum-k);
            }
            m.put(sum,m.getOrDefault(sum,0)+1);

        }
        return ans;
    }
}