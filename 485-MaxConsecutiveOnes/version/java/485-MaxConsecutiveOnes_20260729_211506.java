// Last updated: 7/29/2026, 9:15:06 PM
1class Solution {
2    public int findMaxConsecutiveOnes(int[] nums) {
3        int count=0;
4        int maxc=0;
5        for(int i=0;i<nums.length;i++){
6            if(nums[i]==1){
7                count++;
8            }
9            else{
10                maxc=Math.max(maxc,count);
11                count=0;
12            }
13
14        }
15        maxc=Math.max(maxc,count);
16        return maxc;
17    }
18}