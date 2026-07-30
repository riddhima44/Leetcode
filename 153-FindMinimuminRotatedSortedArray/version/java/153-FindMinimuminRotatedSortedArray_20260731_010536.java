// Last updated: 7/31/2026, 1:05:36 AM
1class Solution {
2    public int findMin(int[] nums) {
3        int s=0;
4        int e=nums.length-1;
5        int ans=Integer.MAX_VALUE;
6        while(s<=e){
7            int m=s+(e-s)/2;
8            if(nums[s]<=nums[e]) {
9                ans=Math.min(ans,nums[s]);
10                return ans;
11            }
12            if(nums[s]<=nums[m]){
13                ans=Math.min(ans,nums[s]);
14                s=m+1;
15            }
16            else{
17                ans=Math.min(ans,nums[m]);
18                e=m-1;
19            }
20        }
21        return ans;
22    }
23}