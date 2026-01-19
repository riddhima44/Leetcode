// Last updated: 1/19/2026, 10:48:17 PM
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int ans1 = maxSubarray(nums);
        int total =0;

        for(int i=0;i<nums.length;i++){
            total += nums[i];
            nums[i] = nums[i] * -1;
        }
        int sum2 = maxSubarray(nums);
        int ans2 = total + sum2;
        if(ans2==0)return ans1;
        return Math.max(ans1,ans2);

    }
    int maxSubarray(int nums[]){  
        int n = nums.length;
        //linear maxsum
        int max = Integer.MIN_VALUE;
        int sum =0;
        for(int i=0;i<n;i++){
            sum += nums[i];
            max = Math.max(max,sum);
            if(sum<0){
                sum =0;
            }
        }
        return max;

        
        

    }
}