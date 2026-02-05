// Last updated: 2/5/2026, 10:34:57 PM
1class Solution {
2    public int[] constructTransformedArray(int[] nums) {
3        int n=nums.length;
4        int[] result=new int[n];
5        for (int i=0;i<n;i++) {
6            if (nums[i]==0) {
7                result[i]=0;
8            } else {
9                int newIdx=(i+nums[i])%n;
10                if (newIdx<0) {
11                    newIdx+=n;
12                }
13                result[i]=nums[newIdx];
14            }
15        }
16        return result;
17    }
18}