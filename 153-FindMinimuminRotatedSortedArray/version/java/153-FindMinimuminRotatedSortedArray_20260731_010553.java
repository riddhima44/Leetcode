// Last updated: 7/31/2026, 1:05:53 AM
1class Solution {
2    public int findMin(int[] nums) {
3        int s=0;
4        int e=nums.length-1;
5        int ans=Integer.MAX_VALUE;
6        while(s<=e){
7            int m=s+(e-s)/2;
8            
9            if(nums[s]<=nums[m]){
10                ans=Math.min(ans,nums[s]);
11                s=m+1;
12            }
13            else{
14                ans=Math.min(ans,nums[m]);
15                e=m-1;
16            }
17        }
18        return ans;
19    }
20}