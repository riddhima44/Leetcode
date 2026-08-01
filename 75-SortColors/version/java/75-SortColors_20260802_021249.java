// Last updated: 8/2/2026, 2:12:49 AM
1class Solution {
2    public void sortColors(int[] nums) {
3        int mid=0;
4        int high=nums.length-1;
5        int low=0;
6        while(mid<=high){
7            if(nums[mid]==0){
8                int temp=nums[mid];
9                nums[mid]=nums[low];
10                nums[low]=temp;
11                low++;
12                mid++;
13            }
14            else if(nums[mid]==1) mid++;
15            else{
16                int temp=nums[mid];
17                nums[mid]=nums[high];
18                nums[high]=temp;
19                high--;
20
21            }
22        }
23    }
24}